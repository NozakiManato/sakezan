package com.example.sakezan.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.sakezan.entity.Item;
import com.example.sakezan.entity.Order;
import com.example.sakezan.form.OrderForm;
import com.example.sakezan.repository.ItemsMapper;
import com.example.sakezan.repository.OrdersMapper;
import com.example.sakezan.service.OrderService;
import com.example.sakezan.utility.HolidayUtil;
import com.example.sakezan.utility.OrderCalculator;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * Order:サービスの実装クラス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	/** DI */
	private final OrdersMapper ordersMapper;
	private final ItemsMapper itemsMapper;
	
	/**
	 * 発注処理
	 */
	@Override
	public void placeOrder(OrderForm form) {
		//発注日は前日なので明日の理想在庫数テーブルを参照するようにする
		LocalDateTime orderDate = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
		LocalDate localDate = orderDate.toLocalDate();
		boolean isWeekend = localDate.getDayOfWeek() == DayOfWeek.FRIDAY || localDate.getDayOfWeek() == DayOfWeek.SATURDAY;
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		
		
		for (Map.Entry<String, Integer> entry : form.getStock().entrySet()) {
			String item_code = entry.getKey();
			int stock = entry.getValue();
			
			Item item = itemsMapper.selectByItem_code(item_code);
			//明日が金、土、祝日かどうかを判断し、発注数を計算する
			if (item != null) {
				int idealStock = (isWeekend || isHoliday) ? item.getIdeal_stock_weekend() : item.getIdeal_stock_weekday();
				int orderQuantity = idealStock - stock;
				//計算したドリンクと発注日、在庫数をorderクラスに格納し、登録する
				if (orderQuantity > 0) {
					Order order = new Order();
					order.setItem_code(item_code);
					order.setOrder_quantity(orderQuantity);
					order.setOrderDate(orderDate);
					order.setStock(stock);
					ordersMapper.insert(order);
					
					//itemsテーブルの在庫を更新
					item.setStock((double) (stock + orderQuantity));
					itemsMapper.update(item);
				}
				
			}
		}
	}
	/**
	 * すべての発注を取得する
	 */
	@Override
	public List<Order> findAllOrder() {

		return ordersMapper.selectAll();
	}
	/**
	 * 特定の日付の発注を取得する
	 */

	@Override
	public List<Order> findOrderByDate(LocalDateTime date) {
		return ordersMapper.selectByDate(date);
	}

	public double calculateTotalAmount(List<Order> orders) {
		return orders.stream()
				.mapToDouble(order -> {
					Item item = itemsMapper.selectByItem_code(order.getItem_code());
					return OrderCalculator.calculateAmount(item, order);
				})
				.sum();
	}
}
