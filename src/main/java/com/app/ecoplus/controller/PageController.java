package com.app.ecoplus.controller;

import java.util.List;
import java.util.Map;

import com.app.ecoplus.entity.Form;
import com.app.ecoplus.service.FormService;
import com.app.ecoplus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.ecoplus.dto.FormDto;
import com.app.ecoplus.dto.user.UserAuthDto;
import com.app.ecoplus.dto.user.UserDto;
import com.app.ecoplus.dto.user.UserRegisterAuthDto;
import com.app.ecoplus.service.ImageService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class PageController {



//	Classe focada na renderização de páginas e gestão dos templates.
	
	private final ImageService imageService;
	private final FormService formService;
	private PageController(ImageService imageService, FormService formService) {
		this.imageService = imageService;
        this.formService = formService;
    }

	@GetMapping("/")
	public String index(Model model) {
		Map <String, String>imageMap = imageService.imagesIndex();
		model.addAllAttributes(imageMap);
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		Map <String, String>imageMap = imageService.imagesLogin();
		model.addAttribute("userAuthDto", new UserAuthDto("",""));
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

	@GetMapping("/register")
	public String register(Model model, UserDto userDto) {
		UserRegisterAuthDto userRegisterAuthDto = new UserRegisterAuthDto("","","","","","","", userDto.getRole());
		model.addAttribute("userRegisterAuthDto", userRegisterAuthDto);
		return "criarconta";
	}


	@PostMapping("/submit/form")
	public String formSubmit( Model model, FormDto formDto) {
		formService.create(formDto.transformaParaObjeto());
		model.addAttribute("formDto", formDto);
		return "form";
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
