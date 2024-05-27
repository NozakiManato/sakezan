package com.example.sakezan.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sakezan.entity.Order;
import com.example.sakezan.form.OrderForm;

/**
 * Order:サービス
 */
public interface OrderService {
	
	/**
	 * 発注を行う
	 */
	void placeOrder(OrderForm form);
	
	/**
	 * 全「発注」を検索する
	 */
	List<Order> findAllOrder();
	
	/**
	 * 特定の日付の発注を取得する
	 */
	List<Order> findOrderByDate(LocalDateTime date);
	
}
