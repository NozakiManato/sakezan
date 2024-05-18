package com.example.sakezan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakezan.entity.Item;
import com.example.sakezan.repository.ItemsMapper;
import com.example.sakezan.service.ItemService;

import lombok.RequiredArgsConstructor;

/**
 * Item: サービス実装クラス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	/** DI */
	private final ItemsMapper itemsMapper;
	
	@Override
	public List<Item> findAllItem() {
		return itemsMapper.selectAll();
	}

	@Override
	public Item findByIdItem(String item_code) {
		// TODO 自動生成されたメソッド・スタブ
		return itemsMapper.selectByItem_code(item_code);
	}

	@Override
	public void insertItem(Item item) {
		// TODO 自動生成されたメソッド・スタブ
		itemsMapper.insert(item);
	}

	@Override
	public void updateItem(Item item) {
		// TODO 自動生成されたメソッド・スタブ
		itemsMapper.update(item);
	}

	@Override
	public void deleteItem(String item_code) {
		// TODO 自動生成されたメソッド・スタブ
		itemsMapper.delete(item_code);
	}
	
	
	
}
