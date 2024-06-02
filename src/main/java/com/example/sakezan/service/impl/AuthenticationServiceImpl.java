package com.example.sakezan.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public List<Authentication> findAllAuthentication() {
		return authenticationsMapper.selectAll();
	}

	@Override
	public Authentication findByUsername(String username) {
		return authenticationsMapper.selectByUsername(username);
	}

	@Override
	public void insertUser(Authentication authentication) {
		//パスワードのハッシュ化
		String hashedPassword = passwordEncoder.encode(authentication.getPassword());
		authentication.setPassword(hashedPassword);
		authenticationsMapper.insert(authentication);
	}

	@Override
	public void updateUser(Authentication authentication) {
		//パスワードのハッシュ化
		String hashedPassword = passwordEncoder.encode(authentication.getPassword());
		authentication.setPassword(hashedPassword);
		authenticationsMapper.update(authentication);
	}

	@Override
	public void deleteUser(String username) {
		authenticationsMapper.delete(username);
	}

}
