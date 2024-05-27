package com.example.sakezan.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sakezan.entity.Item;
import com.example.sakezan.entity.Order;
import com.example.sakezan.form.OrderForm;
import com.example.sakezan.service.ItemService;
import com.example.sakezan.service.OrderService;

import lombok.RequiredArgsConstructor;


/**
 * Order:コントローラ
 */
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	/** DI */
	private final OrderService orderService;
	private final ItemService itemService;
	
	/**
	 *発注を行う 
	 */
	@PostMapping("/placeOrder")
	public String placeOrder(@Validated OrderForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		//=== バリデーションチェック ===
		//入力チェックNG：入力画面に表示する
		if (bindingResult.hasErrors()) {
			return "order/list";
		}
		orderService.placeOrder(form);
		return "redirect;//orders";
	}
	
	/**
	 * 発注フォームを表示する
	 */
	@GetMapping
	public String list(Model model) {
		List<Item> items = itemService.findAllItem();
		model.addAttribute("items", items);
		model.addAttribute("orders", orderService.findAllOrder());
		return "order/form";
	}
	/**
	 * 今日の発注を取得し表示する
	 */
	@GetMapping("/today")
	public String TodayOrders(Model model) {
		LocalDateTime today = LocalDateTime.now().toLocalDate().atStartOfDay();
		List<Order> orders = orderService.findOrderByDate(today);
		model.addAttribute("orders", orders);
		return "order/list";
	}
	
}
