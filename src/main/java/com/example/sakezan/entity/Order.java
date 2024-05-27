package com.example.sakezan.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * オーダー：エンティティ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	/** ID */
	private Long id;
	/** 商品コード */
	private String item_code;
	/** 在庫数 */
	private double stock = 0.0;
	/** 発注数量 */
	int order_quantity;
	/** 発注日 */
	private LocalDateTime orderDate;
}
