package com.app.ecoplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Exclude adicionado para evitar autenticação do Spring Security.
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class EcoplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoplusApplication.class, args);
		System.out.println("Teste");
	}

}
