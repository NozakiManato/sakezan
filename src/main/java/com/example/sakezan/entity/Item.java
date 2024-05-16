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
	/** お酒の商品コード */
	private String item_code;
	/** お酒の名前 */
	private String drink_name;
	/**  お酒のサイズ */
	private String specification;
	/** お酒の値段 */
	private Integer price;
	/** お酒の在庫 */
	private Double stock;
	/** お酒の発注数 */
	private Integer order_quantity = 0;
	/** 平日の理想的な在庫数 */
	private Double ideal_stock_weekday;
	/** 週末の理想的な在庫数 */
	private Double ideal_stock_weekend;
	/** 商品のカテゴリー */
	private DrinkCategory drink_category;
}
