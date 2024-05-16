package com.example.sakezan.service;

import java.util.List;

import com.example.sakezan.entity.Item;

/**
 * Item:サービス
 */
public interface ItemService {
	/**
	 * 全「ドリンク」を検索する
	 */
	List<Item> findAllItem();
	
	/**
	 * 指定されたIDの「ドリンク」を検索する
	 */
	Item findByIdItem(Integer id);
	
	/**
	 * 「ドリンク」を登録する
	 */
	void inserItem(Item item);
	
	/**
	 * 
	 */
}
