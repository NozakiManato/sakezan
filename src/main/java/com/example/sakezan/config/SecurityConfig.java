package com.example.sakezan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//securityFilterChainのBean定義
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			//★HTTPリクエストに対するセキュリティ設定
			.authorizeHttpRequests(authz -> authz
			//「/login」へのアクセスは認証を必要としない
			.requestMatchers("/login").permitAll()
			//【管理者権限設定】url:/items/**は管理者しかアクセスできない
			.requestMatchers("/items/**").hasAuthority("ADMIN")
			//その他のリクエストは認証が必要
			.anyRequest().authenticated())
			//★フォームベースのログイン設定
			.formLogin(form -> form
			//カスタムログインページのURLを指定
			.loginPage("/login")
			//ログイン処理のURLを指定
			.loginProcessingUrl("/authentication")
			//ユーザーメインのname属性を指定
			.usernameParameter("usernameInput")
			//パスワードのname属性を指定
			.passwordParameter("passwordInput")
			//ログイン成功時のリダイレクト先を指定
			.defaultSuccessUrl("/")
			//ログイン失敗時のリダイレクト先を指定
			.failureUrl("/login?error"))
			//★ログアウト設定
			.logout(logout -> logout
			//ログアウトを処理するURLを指定
			.logoutUrl("/logout")
			//ログアウト成功時のリダイレクト先を指定
			.logoutSuccessUrl("/login?logout")
			//ログアウト時にセッションを無効にする
			.invalidateHttpSession(true)
			//ログアウト時にCookieを削除する
			.deleteCookies("JSESSIONID")
			);
		return http.build();
	}
 }
	

