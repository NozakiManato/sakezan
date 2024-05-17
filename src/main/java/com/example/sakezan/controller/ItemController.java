package com.example.sakezan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sakezan.entity.Item;
import com.example.sakezan.service.ItemService;

import lombok.RequiredArgsConstructor;



/**
 * Item: コントローラ
 */
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
	
	/** DI */
	private final ItemService itemService;
	
	/**
	 * 「ドリンク」の一覧を表示する
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("items", itemService.findAllItem());
		return "item/list";
	}
	
	/**
	 * 指定されたItem_codeの「すること」の詳細を表示する
	 */
	@GetMapping("/{item_code}")
	public String detail(@PathVariable String item_code, Model model,
			RedirectAttributes attributes) {
		//「ドリンク」Item_codeに対応する「ドリンク」情報を取得
		Item item = itemService.findByIdItem(item_code);
		if (item != null) {
			model.addAttribute("items", itemService.findByIdItem(item_code));
			return "item/detail";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
		}
		return "redirect/items";
	}
	
}
