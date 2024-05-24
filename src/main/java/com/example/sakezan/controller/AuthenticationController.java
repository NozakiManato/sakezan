package com.example.sakezan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sakezan.entity.Authentication;
import com.example.sakezan.form.AuthenticationForm;
import com.example.sakezan.helper.AuthenticationHelper;
import com.example.sakezan.service.AuthenticationService;

import lombok.RequiredArgsConstructor;


/**
 * User:コントローラ
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthenticationController {
	/**
	 * DI
	 */
	private final AuthenticationService authenticationService;
	
	/**
	 * Userの一覧を表示する
	 */
	@GetMapping
	public String list(Model model) {
		model.addAttribute("users", authenticationService.findAllAuthentication());
		return "user/list";
	}
	
	/**
	 * 指定されたusernameのUserの詳細を表示する
	 */
	@GetMapping("/{usernameInput}")
	public String detail(@PathVariable String usernameInput, Model model, 
			RedirectAttributes attributes) {
		//usernameに対応する「User」情報を取得
		Authentication authentication = authenticationService.findByUsername(usernameInput);
		if (authentication != null) {
			model.addAttribute("user", authenticationService.findByUsername(usernameInput));
			return "user/detail";
		} else {
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
		}
		return "redirect:/users";
	}
	
	//=== 登録・更新処理追加 ===
	@GetMapping("/form")
	public String newUser(@ModelAttribute AuthenticationForm form) {
		//新規登録画面設定
		form.setIsNew(true);
		return "user/form";
	}
	
	/**
	 * 新規登録を実行する
	 */
	@PostMapping("/save")
	public String create(@Validated AuthenticationForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		//TODO: process POST request
		//=== バリデーションチェック ===
		//入力チェックNG:入力画面に表示する
		if (bindingResult.hasErrors()) {
			//新規登録画面の設定
			form.setIsNew(true);
			return "user/form";
		}
		//エンティティの変換
		Authentication authentication = AuthenticationHelper.convertAuthentication(form);
		//登録実行
		authenticationService.insertUser(authentication);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "新しいユーザーが作成されました");
		//PRGパターン
		return "redirect:/users";
	}
	
	/**
	 *指定されたusernameの 修正画面を表示する
	 */
	@GetMapping("/edit/{username}")
	public String edit(@PathVariable String username, Model model,
			RedirectAttributes attributes) {
		//usernameに対応する「ユーザー」を取得
		Authentication target = authenticationService.findByUsername(username);
		if (target != null) {
			//対象データがある場合はFormへの変換
			AuthenticationForm form = AuthenticationHelper.convertAuthenticationForm(target);
			//モデルに格納
			model.addAttribute("authenticationForm", form);
			return "user/form";
		} else {
			//対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMessage", "対象データがありません");
			//一覧画面へリダイレクト
			return "redirect:/users";
		}
	}
	
	/**
	 * 「ユーザー」の情報を更新する
	 */
	@PostMapping("/update")
	public String update(@Validated AuthenticationForm form,
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		//=== バリデーションチェック ===
		//入力チェックNG：入力画面に表示する
		if (bindingResult.hasErrors()) {
			//更新画面の設定
			form.setIsNew(false);
			return "user/form";
		}
		//エンティティへの変換
		Authentication authentication = AuthenticationHelper.convertAuthentication(form);
		//更新処理
		authenticationService.updateUser(authentication);
		attributes.addFlashAttribute("message", "ドリンクが更新されました");
		//PRGパターン
		return "redirect:/users";
	}
	
	/**
	 * 指定されたusernameの「ユーザー」を削除する
	 */
	@PostMapping("/delete/{username}")
	public String delete(@PathVariable String username, RedirectAttributes attributes) {
		//削除処理
		authenticationService.deleteUser(username);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "ユーザーが削除されました");
		//PRGパターン
		return "redirect:/users";
	}	
}
