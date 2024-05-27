package com.example.sakezan.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sakezan.entity.Authentication;

@Mapper
public interface AuthenticationsMapper {
	
	/**
	 * すべてのユーザーを取得する
	 */
	List<Authentication> selectAll();
	/**
	 * ユーザー名でログイン情報を取得する
	 */
	Authentication selectByUsername(@Param("username") String username);
	
	/**
	 * ユーザーを登録する
	 */
	void insert(Authentication authentication);
	
	/**
	 * ユーザーを更新する
	 */
	void update(Authentication authentication);
	
	/**
	 * ユーザーを削除する
	 */
	void delete(@Param("username") String username);
}
