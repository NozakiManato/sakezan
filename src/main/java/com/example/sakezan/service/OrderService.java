package com.example.sakezan.service;

import java.util.List;

import com.example.sakezan.entity.Order;

/**
 * Order:サービス
 */
public interface OrderService {
	
	/**
	 * 発注を行う
	 */
	void placeOrder(List<Order> orders);
	/**
	 * 税率計算する
	 */
	int calculateAmount(Order order);
	/**
	 * 酒残を検索する
	 */
	List<Order> findOrder();
	/**
	 * 在庫数を更新する
	 */
	void updateStock(List<Order> orders);

}
