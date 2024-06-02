package com.example.sakezan.utility;

import com.example.sakezan.entity.Item;
import com.example.sakezan.entity.Order;

public class OrderCalculator {
	
	public static double calculateTax(Item item) {
		//お酒は税率10%、ソフトドリンクは税率8%
		switch (item.getDrink_category()) {
		case ALCOHOL: 
			return 0.10;
		case SOFT_DRINK:
			return 0.08;
		
		default:
			return 0.0;
		}
	}
	
	public static double calculateAmount(Item item, Order order) {
		double taxRate = calculateTax(item);
		return order.getOrder_quantity() * item.getPrice() * (1 + taxRate);
	}
}
