package com.example.sakezan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SakezanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakezanApplication.class, args);
	}
}
