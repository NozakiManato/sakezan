package com.example.sakezan.form;

import com.example.sakezan.entity.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザー：Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationForm {
	/** ユーザーのユーザー名*/
	@NotBlank(message = "名前(ローマ字)は必須です")
	private String usernameInput;
	/** ユーザーのパスワード */
	@NotBlank(message = "パスワードは必須です")
	private String passwordInput;
	/** ユーザーの権限 */
	@Enumerated(EnumType.STRING)
	@NotNull(message = "権限は必須です")
	private Role authority;
	/** 新規判定 */
	private Boolean isNew;
	/** ユーザーのディスプレイ名前 */
	@NotBlank(message = "名前(日本語)は必須です")
	private String displayname;
	
}
