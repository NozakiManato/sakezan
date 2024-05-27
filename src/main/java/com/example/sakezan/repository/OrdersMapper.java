package com.example.sakezan.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakezan.entity.Order;

/**
 * Order：リポジトリ
 */
@Mapper
public interface OrdersMapper {
	/**
	 * 酒残の情報すべて取得する
	 */
	List<Order> selectAll();
	
	/**
	 * 特定の日付の酒残の情報を取得する
	 */
	List<Order> selectByDate(LocalDateTime orderDate);
	
	/**
	 * 酒残の情報を登録する
	 */
	void insert(Order order);
	
}
