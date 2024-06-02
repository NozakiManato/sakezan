package com.example.sakezan.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakezan.entity.Order;

/**
 * Order：リポジトリ
 */
@Mapper
public interface OrdersMapper {
	/**
	 * 酒残を取得する
	 */
	List<Order> selectAll(); 
	/**
	 * Item_codeから酒残を取得する
	 */
	Order selectByItemCode(String item_code);
	/**
	 * 在庫の更新
	 */
	void updateStock(Order order);
	/**
	 * 在庫と発注数の更新
	 */
	void update(Order order);
}
