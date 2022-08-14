package com.kodigoApplaudo.group2.bankingSpring;

import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ManagerRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.UserService;
import com.kodigoApplaudo.group2.bankingSpring.domain.Role;
import com.kodigoApplaudo.group2.bankingSpring.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
//@Import(SwaggerConfig.class)
public class BankingSpringApplication {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(BankingSpringApplication.class, args);
	}



	/*
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_EMPLOYEE"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));

			Manager manager = new Manager();
			manager.setManager_name("Patrick");
			manager.setPhone("2525-8585");

			manager.setUsername("patrick123");

			userService.saveManager(manager);

			userService.saveUser(new User(null,manager.getUsername(),"12345", new ArrayList<>()));

			userService.addRoleToUser(manager.getUsername(),"ROLE_ADMIN");
		};

	} */

}