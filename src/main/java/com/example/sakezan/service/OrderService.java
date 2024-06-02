package com.example.sakezan.service;

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
	 * 酒残を検索する
	 */
	List<Order> findOrder();
	/**
	 * 在庫数を更新する
	 */
	void updateStock(List<Order> orders);
}
