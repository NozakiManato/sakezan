package com.example.sakezan.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sakezan.entity.Order;
import com.example.sakezan.repository.OrdersMapper;
import com.example.sakezan.service.OrderService;
import com.example.sakezan.utility.HolidayUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * Order:サービスの実装クラス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	/**
	 * DI
	 */
	private final OrdersMapper ordersMapper;
	
	/**
	 * 発注処理
	 */
	@Override
	public void placeOrder(List<Order> orders) {
		//発注日は前日なので明日の理想在庫数テーブルを参照するようにする
		LocalDateTime orderDate = LocalDateTime.now().plus(1, ChronoUnit.DAYS).minus(2, ChronoUnit.HOURS);
		LocalDate localDate = orderDate.toLocalDate();
		boolean isWeekend = localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY;
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		
		for (Order order : orders) {
			if (order != null) {
				int ideal_stock = (isWeekend || isHoliday) ? order.getIdeal_stock_weekend() : order.getIdeal_stock_weekday();
				double currentStock = order.getStock();
				int order_quantity = (int)(ideal_stock - currentStock + 0.7);
				//計算したドリンクと在庫数をorderクラスに格納し、登録する
				if (order_quantity >= 0) {
					order.setOrder_quantity(order_quantity);
					order.setStock((double)(currentStock + order_quantity));
					ordersMapper.update(order);
				} else {
					order.setOrder_quantity(0);
					order.setStock(currentStock);
					ordersMapper.update(order);
				}
				//各注文の小計を計算
				int amount = calculateAmount(order);
				order.setAmount(amount);
			}
		}
	}
	
	@Override
	public void exeptionPlaceOrder(List<Order> orders) {
		// TODO 自動生成されたメソッド・スタブ
		for (Order order : orders) {
			if (order != null) {
				int ideal_stock =  order.getIdeal_stock_weekend();
				double currentStock = order.getStock();
				int order_quantity = (int)(ideal_stock - currentStock + 0.7);
				//計算したドリンクと在庫数をorderクラスに格納し、登録する
				if (order_quantity > 0) {
					order.setOrder_quantity(order_quantity);
					order.setStock((double)(currentStock + order_quantity));
					ordersMapper.update(order);
				} else {
					order.setOrder_quantity(0);
					order.setStock(currentStock);
					ordersMapper.update(order);
				}
				//各注文の小計を計算
				int amount = calculateAmount(order);
				order.setAmount(amount);
			}
		}
	}
	
	
	@Override
	public List<Order> findOrder() {
		return ordersMapper.selectAll();
	}

	@Override
	public void updateStock(List<Order> orders) {
		for (Order order : orders) {
			ordersMapper.updateStock(order);
		}
	}

	@Override
    public int calculateAmount(Order order) {
        double taxRate = calculateTax(order);
        return (int) (order.getOrder_quantity() * order.getPrice() * (1 + taxRate));
    }

    private double calculateTax(Order order) {
        switch (order.getDrink_category()) {
            case ALCOHOL: 
                return 0.10;
            case SOFT_DRINK:
                return 0.08;
            default:
                return 0.0;
        }
    }

}
