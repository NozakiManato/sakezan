package com.example.sakezan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sakezan.entity.Item;
import com.example.sakezan.form.ItemForm;
import com.example.sakezan.helper.ItemHelper;
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
			model.addAttribute("item", itemService.findByIdItem(item_code));
			return "item/detail";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
		}
		return "redirect/items";
	}
	
	//=== 登録・更新処理追加 ===
		@GetMapping("/form")
		public String newItem(@ModelAttribute ItemForm form) {
			//新規登録画面の設定
			form.setIsNew(true);
			return "item/form";
		}
	
	/**
	 * 新規登録を実行する
	 */
	@PostMapping("/save")
	public String create(ItemForm form,
			RedirectAttributes attributes) {
		//TODO: process POST request
		//エンティティの変換
		Item Item = ItemHelper.convertItem(form);
		//登録実行
		itemService.insertItem(Item);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "新しいドリンクが作成されました");
		//PRGパターン
		return "redirect:/items";
	}
	
	/**
	 * 指定されたIDの修正画面を表示する
	 */
	@GetMapping("/edit/{item_code}")
	public String edit(@PathVariable String item_code, Model model,
			RedirectAttributes attributes) {
		//item_codeに対応する「ドリンク」を取得
		Item target = itemService.findByIdItem(item_code);
		if (target != null) {
			//対象データがある場合はFormへの変換
			ItemForm form = ItemHelper.convertItemForm(target);
			//モデルに格納
			model.addAttribute("itemForm", form);
			return "item/form";
		} else {
			//対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			//一覧画面へリダイレクト
			return "redirect:/items";
		}
	}
	
	/**
	 * 「ドリンク」の情報を更新する
	 */
	@PostMapping("/update")
	public String update(ItemForm form,
			RedirectAttributes attributes) {
		//エンティティへの変換
		Item Item = ItemHelper.convertItem(form);
		//更新処理
		itemService.updateItem(Item);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "ドリンクが更新されました");
		//PRGパターン
		return "redirect:/items";
	}
	
	/**
	 * 指定されたItem_codeの「ドリンク」を削除する
	 */
	@PostMapping("/delete/{item_code}")
	public String delete(@PathVariable String item_code, RedirectAttributes attributes) {
		//TODO: process POST request
		//削除処理
		itemService.deleteItem(item_code);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "ドリンクが削除されました");
		//PRGパターン
		return "redirect:/items";
	}
	
	
}