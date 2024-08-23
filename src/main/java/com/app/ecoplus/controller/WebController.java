package com.app.ecoplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.ecoplus.DTO.FormDto;
import com.app.ecoplus.service.FormService;

@Controller
public class WebController {
	
	
	private final FormService formService;

   	public WebController(FormService formService) {
       this.formService = formService;
   	}
	
    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("formDto") FormDto formDto, Model model) {
        // Processar o input
        formService.create(formDto.transformaParaObjeto());
        return "redirect:/"; // nome do template que exibirá o resultado
	    }
}
