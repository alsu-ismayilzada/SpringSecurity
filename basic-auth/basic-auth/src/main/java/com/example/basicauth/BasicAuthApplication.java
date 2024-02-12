package com.example.basicauth;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.Role;
import com.example.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		creayeDummyData();
	}


	private void creayeDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Alsu")
				.username("alsu")
				.password("alsu")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);
		CreateUserRequest request1 = CreateUserRequest.builder()
				.name("Admin")
				.username("admin")
				.password("admin")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request1);

	}
}
