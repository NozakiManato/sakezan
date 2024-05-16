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
	Item selectByItem_code(@Param("item_code") String item_code);
	
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
	void delete(@Param("item_code") String item_code);
	
}
