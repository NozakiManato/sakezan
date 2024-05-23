package com.example.sakezan.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakezan.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
	/**
	 * ユーザー名でログイン情報を取得する
	 */
	Authentication selectByUsername(String username);
}
