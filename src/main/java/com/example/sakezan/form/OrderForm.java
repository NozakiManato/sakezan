package com.example.sakezan.form;

import java.util.List;

import com.example.sakezan.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {
	private List<Order> orders;
}
