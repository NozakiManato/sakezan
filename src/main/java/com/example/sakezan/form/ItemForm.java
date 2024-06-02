package com.example.sakezan.form;

import com.example.sakezan.entity.DrinkCategory;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	/** ドリンクの商品コード */
	//item_codeではなく、drink_codeに変える
	@Pattern(regexp = "\\d{6}", message = "商品コードは６文字の数字でなければなりません")
	private String item_code;
	/** ドリンクの名前 */
	@NotBlank(message = "ドリンク名は必須です")
	private String drink_name;
	/**  ドリンクのサイズ */
	@NotBlank(message = "サイズは必須です")
	private String specification;
	/** ドリンクの単価 */
	@NotNull(message = "単価は必須です")
	private Integer price;
	/** ドリンクの在庫 */
	@NotNull(message = "在庫は必須です")
	private Double stock = 0.0;
	@NotNull(message = "発注数は必須です")
	private Integer order_quantity = 0;
	/** 平日の理想的な在庫数 */
	private Integer ideal_stock_weekday;
	/** 週末の理想的な在庫数 */
	private Integer ideal_stock_weekend;
	/** ドリンクのカテゴリー */
	@Enumerated(EnumType.STRING)
    @NotNull(message = "種類は必須です")
	private DrinkCategory drink_category;
	/** 新規判定 */
	private Boolean isNew;
}
