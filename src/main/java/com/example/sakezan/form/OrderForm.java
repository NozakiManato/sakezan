package com.example.sakezan.form;

import java.util.Map;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
	/** 商品コードごとの在庫数 */
	@NotNull(message = "在庫数は必須です")
	private Map<String, Integer> stock;
}
