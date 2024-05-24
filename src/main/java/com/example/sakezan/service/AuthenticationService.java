package com.example.sakezan.service;

import java.util.List;

import com.example.sakezan.entity.Authentication;

/**
 * Authenctication：サービス
 */
public interface AuthenticationService {
	/**
	 * 全ユーザーを検索する
	 */
	List<Authentication> findAllAuthentication();
	
	/**
	 * 指定されたusernameのユーザーを検索する
	 */
	Authentication findByUsername(String username);
	
	/**
	 * ユーザーを新規登録する
	 */
	void insertUser(Authentication authentication);
	
	/**
	 * ユーザーを更新する
	 */
	void updateUser(Authentication authentication);
	
	/**
	 * 指定されたusernameのユーザーを削除する
	 */
	void deleteUser(String username);
}
