package com.kodigoApplaudo.group2.bankingSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BankingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSpringApplication.class, args);
	}

}