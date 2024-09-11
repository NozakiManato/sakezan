package com.example.sakezan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ドリンク:エンティティ
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	/** ID */
	private Integer id;
	/** 残数を数える時のID */
	private Integer quantity_id;
	/** ドリンクの商品コード */
	private String item_code;
	/** ドリンクの名前 */
	private String drink_name;
	/**  ドリンクのサイズ */
	private String specification;
	/** ドリンクの値段 */
	private Integer price;
	/** ドリンクの在庫 */
	private Double stock;
	/** ドリンクの発注数 */
	private Integer order_quantity;
	/** 平日の理想的な在庫数 */
	private Integer ideal_stock_weekday;
	/** 週末の理想的な在庫数 */
	private Integer ideal_stock_weekend;
	/** ドリンクのカテゴリー */
	private DrinkCategory drink_category;
}
