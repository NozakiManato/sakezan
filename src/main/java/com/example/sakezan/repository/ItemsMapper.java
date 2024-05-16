package com.example.sakezan.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sakezan.entity.Item;

/**
 * Items:リポジトリ
 */
@Mapper
public interface ItemsMapper {
	/**
	 * すべての「ドリンク」を取得する
	 */
	List<Item> selectAll();
	/**
	 * 指定されたIDに対応する「ドリンク」を取得する
	 */
	Item selectById(@Param("id") Integer id);
	
	/**
	 * 「ドリンク」を登録する
	 */
	void insert(Item item);
	
	/**
	 *「ドリンク」を更新する 
	 */
	void update(Item item);
	
	/**
	 * 指定されたIDの「ドリンク」を削除する
	 */
	void delete(@Param("id") Integer id);
	
}
