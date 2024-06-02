package com.example.sakezan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sakezan.entity.Order;
import com.example.sakezan.form.OrderForm;
import com.example.sakezan.repository.OrdersMapper;
import com.example.sakezan.service.OrderService;
<<<<<<< HEAD
import com.example.sakezan.utility.HolidayUtil;
import com.example.sakezan.utility.OrderCalculator;
=======
>>>>>>> 5273f408be4f90df45f685bfe60a9bfa27f9a3a5

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
	public void placeOrder(OrderForm form) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	@Override
	public List<Order> findOrder() {
		return ordersMapper.selectAll();
	}

	@Override
	public void updateStock(List<Order> orders) {
		for (Order order : orders) {
			System.out.println("Updating stock for item: " + order.getItem_code() + "to " +order.getStock());
			ordersMapper.updateStock(order);
		}
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
