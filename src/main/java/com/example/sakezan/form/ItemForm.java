package com.example.sakezan.form;

import com.example.sakezan.entity.DrinkCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ドリンク:Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemForm {
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
	/** 新規判定 */
	private Boolean isNew;
}
