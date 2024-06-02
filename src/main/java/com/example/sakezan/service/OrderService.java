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
<<<<<<< HEAD
	List<Order> findOrderByDate(LocalDateTime date);
	
	/**
	 * 税率計算をする
	 */
	double calculateTotalAmount(List<Order> orders);
=======
	void updateStock(List<Order> orders);
>>>>>>> 5273f408be4f90df45f685bfe60a9bfa27f9a3a5
}
