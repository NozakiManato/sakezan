package com.example.sakezan.utility;

import com.example.sakezan.entity.Order;

public class OrderCalculator {
	
	public static double calculateTax(Order order) {
		//お酒は税率10%、ソフトドリンクは税率8%
		switch (order.getDrink_category()) {
		case ALCOHOL: 
			return 0.10;
		case SOFT_DRINK:
			return 0.08;
		
		default:
			return 0.0;
		}
	}
	
	public static int calculateAmount(Order order) {
		double taxRate = calculateTax(order);
		return (int) (order.getOrder_quantity() * order.getPrice() * (1 + taxRate));
	}
}
