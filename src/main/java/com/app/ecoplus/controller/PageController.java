package com.app.ecoplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/password")
	public String password() {
		return "password";
	}
	
	
	@GetMapping("/faq")
	public String faq() {
		return "faq";
	}
	
	@GetMapping("/email")
	public String email() {
		return "email";
	}
	
	@GetMapping("/criarconta")
	public String criarconta() {
		return "criarconta";
	}

	@GetMapping("/criarcontadois")
	public String criarcontadois() {
		return "criarcontadois";
	}
	@GetMapping("/chat")
	public String chat() {
		return "Preencher este local";
	}
	
	@GetMapping("/sobrenos")
	public String sobrenos() {
		return "";					// Colocar html aqui.
	}
}
