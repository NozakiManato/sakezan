package com.example.sakezan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sakezan.entity.Item;
import com.example.sakezan.repository.ItemsMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SakezanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakezanApplication.class, args)
		.getBean(SakezanApplication.class).exe();
	}
	
	private final ItemsMapper mapper;
	
	private void exe() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("===全件検索===");
		for (Item row : mapper.selectAll()) {
			System.out.println(row);
		}
		
		System.out.println("===1件検索===");
		System.out.println(mapper.selectByItem_code("000001"));
		Item item = new Item();
		item.setDrink_name("ジンジャーエール");
		item.setItem_code("100002");
		item.setPrice(65);
		item.setStock(0.0);
		item.setSpecification("190ml");
		item.setIdeal_stock_weekday(15.0);
		item.setIdeal_stock_weekend(21.0);
		mapper.insert(item);
		
		System.out.println("===登録確認===");
		System.out.println(mapper.selectByItem_code("100002"));
		
		Item target = mapper.selectByItem_code("100002");
		target.setDrink_name("ジンジャエール辛口");
		target.setPrice(88);
		mapper.update(target);
		System.out.println("===登録確認===");
		System.out.println(mapper.selectByItem_code("100002"));
		
		mapper.delete("100002");;
		System.out.println("===削除確認===");
		for (Item row : mapper.selectAll()) {
			System.out.println(row);
		}
	}
	

	
}
