package com.example.sakezan.entity;

import java.time.LocalDateTime;

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
	/** お酒ID */
	private Integer id;
	/** お酒の名前 */
	private String drink;
	/** お酒の商品コード */
	private String code;
	/** お酒の値段 */
	private Integer price;
	/** お酒の在庫 */
	private Double stock;
	/** 平日の理想的な在庫数 */
	private Double ideal_stock_weekday;
	/** 週末の理想的な在庫数 */
	private Double ideal_stock_weekend;
	/** 発注が行われた日時 */
	private LocalDateTime order_date;
	/** 商品のカテゴリー */
	private DrinkCategory drink_category;
}
