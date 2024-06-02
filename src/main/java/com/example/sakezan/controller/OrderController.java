package com.example.sakezan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sakezan.form.OrderForm;
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
	
	/**
	 * 酒残フォームを表示する
	 */
	@GetMapping
	public String form(Model model) {
		OrderForm orderForm = new OrderForm();
        orderForm.setOrders(orderService.findOrder());
        model.addAttribute("orderForm", orderForm);
		return "order/form";
	}
	
	/**
	 * 在庫の更新処理
	 */
	@PostMapping("/update")
	public String update(OrderForm form,
			RedirectAttributes attributes) {
		System.out.println("FROM data: " + form.getOrders());
		orderService.updateStock(form.getOrders());
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "在庫が更新されました");
		//PRGパターン
		return "redirect:/orders/confirm";
	}
	
	/**
	 * 確認画面を表示する
	 */
	@GetMapping("/confirm")
	public String confirm(Model model) {
        OrderForm orderForm = new OrderForm();
        orderForm.setOrders(orderService.findOrder());
        model.addAttribute("orderForm", orderForm);
		return "order/confirm";
	}
	
	
	
	
	
	
	
	
	
}
