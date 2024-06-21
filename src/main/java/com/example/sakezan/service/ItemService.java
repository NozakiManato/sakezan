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
	 * 指定されたIdの「ドリンク」を検索する
	 */
	Item findById(Integer id);
	
	/**
	 * 「ドリンク」を新規登録する
	 */
	void insertItem(Item item);
	
	/**
	 * 「ドリンク」を更新する
	 */
	void updateItem(Item item);
	
	/**
	 * 指定されたIdの「ドリンク」を削除する
	 */
	void deleteItem(Integer id);
}
