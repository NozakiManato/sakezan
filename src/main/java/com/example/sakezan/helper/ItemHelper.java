package com.example.sakezan.helper;

import com.example.sakezan.entity.Item;
import com.example.sakezan.form.ItemForm;

/**
 * Item:ヘルパー
 */
public class ItemHelper {
	/**
	 * Itemへの変換
	 */
	public static Item convertItem(ItemForm form) {
		Item item = new Item();
		item.setItem_code(form.getItem_code());
		item.setDrink_name(form.getDrink_name());
		item.setSpecification(form.getSpecification());
		item.setPrice(form.getPrice());
		item.setStock(form.getStock());
		item.setOrder_quantity(form.getOrder_quantity());
		item.setIdeal_stock_weekday(form.getIdeal_stock_weekday());
		item.setIdeal_stock_weekend(form.getIdeal_stock_weekend());
		item.setDrink_category(form.getDrink_category());
		return item;
	}
	
	/**
	 * ItemFormへの変換
	 */
	public static ItemForm convertItemForm(Item item) {
		ItemForm form = new ItemForm();
		form.setItem_code(item.getItem_code());
		form.setDrink_name(item.getDrink_name());
		form.setSpecification(item.getSpecification());
		form.setPrice(item.getPrice());
		form.setStock(item.getStock());
		form.setOrder_quantity(item.getOrder_quantity());
		form.setIdeal_stock_weekday(item.getIdeal_stock_weekday());
		form.setIdeal_stock_weekend(item.getIdeal_stock_weekend());
		form.setDrink_category(item.getDrink_category());
		return form;
		
		
		
		
		
		
	}
}
