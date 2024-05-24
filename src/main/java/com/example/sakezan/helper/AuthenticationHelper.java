package com.example.sakezan.helper;
/**
 * Authentication：ヘルパー
 */

import com.example.sakezan.entity.Authentication;
import com.example.sakezan.form.AuthenticationForm;

public class AuthenticationHelper {
	/**
	 * Authenticationへの変換
	 */
	public static Authentication convertAuthentication(AuthenticationForm form) {
		Authentication authentication = new Authentication();
		authentication.setUsername(form.getUsernameInput());
		authentication.setPassword(form.getPasswordInput());
		authentication.setAuthority(form.getAuthority());
		authentication.setDisplayname(form.getDisplayname());
		return authentication;
	}
	
	/**
	 * AuthenticationFormへの変換
	 */
	public static AuthenticationForm convertAuthenticationForm(Authentication authentication) {
		AuthenticationForm form = new AuthenticationForm();
		form.setUsernameInput(authentication.getUsername());
		form.setPasswordInput(authentication.getPassword());
		form.setAuthority(authentication.getAuthority());
		form.setDisplayname(authentication.getDisplayname());
		return form;
	}
}
