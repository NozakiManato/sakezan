package com.example.sakezan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sakezan.entity.Order;
import com.example.sakezan.form.OrderForm;
import com.example.sakezan.repository.OrdersMapper;
import com.example.sakezan.service.OrderService;

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
}
