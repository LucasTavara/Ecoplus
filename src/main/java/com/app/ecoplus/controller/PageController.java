package com.app.ecoplus.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.ecoplus.DTO.FormDto;
import com.app.ecoplus.DTO.RegisterRequestDto;
import com.app.ecoplus.service.ImageService;


@Controller

public class PageController {



//	Classe focada na renderização de páginas e gestão dos templates.
	
	private final ImageService imageService;

	private PageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@GetMapping("/")
	public String index(Model model) {
		Map <String, String>imageMap = imageService.imagesIndex();
		model.addAllAttributes(imageMap);
		return "index";
	}

	@GetMapping("/loginconta")
	public String login(Model model) {
		Map <String, String>imageMap = imageService.imagesLogin();
		model.addAllAttributes(imageMap);
		return "login";
	}

	@GetMapping("/password")
	public String password(Model model) {
		Map <String, String>imageMap = imageService.imagesPassword();
		model.addAllAttributes(imageMap);
		return "password";
	}


	@GetMapping("/faq")
	public String faq(Model model) {
		Map <String, String>imageMap = imageService.imagesFaq();
		model.addAllAttributes(imageMap);
		return "faq";
	}

	@GetMapping("/form")
	public String form(Model model) {
		Map <String, String>imageMap = imageService.imagesForm();
		model.addAttribute("formDto", new FormDto());
		model.addAllAttributes(imageMap);
		return "form";
	}

	@GetMapping("/criarconta")
	public String criarconta(Model model) {
	    model.addAttribute("registerRequestDto", new RegisterRequestDto("","","","","",1));
		return "criarconta";
	}

	@GetMapping("/criarcontadois")
	public String criarcontadois(Model model) {
		Map <String, String>imageMap = imageService.imagesIndex();
		model.addAllAttributes(imageMap);
		return "cirarcontadois";
	}
	@GetMapping("/chat")
	public String chat() {
		return "Preencher este local";
	}

	@GetMapping("/sobrenos")
	public String sobrenos(Model model) {
		Map <String, String>imageMap = imageService.imagesSobrenos();
		model.addAllAttributes(imageMap);
		return "sobrenos";
	}
}
