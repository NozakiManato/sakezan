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
	 * 指定されたItem_codeの「ドリンク」を検索する
	 */
	Item findByIdItem(String item_code);
	
	/**
	 * 「ドリンク」を新規登録する
	 */
	void inserItem(Item item);
	
	/**
	 * 「ドリンク」を更新する
	 */
	void updateItem(Item item);
	
	/**
	 * 指定されたItem_codeの「ドリンク」を削除する
	 */
	void deleteItem(String item_code);
}
