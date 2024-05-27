package com.example.sakezan.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sakezan.entity.Authentication;
import com.example.sakezan.repository.AuthenticationsMapper;
import com.example.sakezan.service.AuthenticationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
	/**
	 * DI
	 */
	private final AuthenticationsMapper authenticationsMapper;
	
	@Override
	public List<Authentication> findAllAuthentication() {
		// TODO 自動生成されたメソッド・スタブ
		return authenticationsMapper.selectAll();
	}

	@Override
	public Authentication findByUsername(String username) {
		// TODO 自動生成されたメソッド・スタブ
		return authenticationsMapper.selectByUsername(username);
	}

	@Override
	public void insertUser(Authentication authentication) {
		// TODO 自動生成されたメソッド・スタブ
		authenticationsMapper.insert(authentication);
	}

	@Override
	public void updateUser(Authentication authentication) {
		// TODO 自動生成されたメソッド・スタブ
		authenticationsMapper.update(authentication);
	}

	@Override
	public void deleteUser(String username) {
		// TODO 自動生成されたメソッド・スタブ
		authenticationsMapper.delete(username);
	}

}
