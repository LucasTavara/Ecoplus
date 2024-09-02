package com.app.ecoplus.controller.email;


import com.app.ecoplus.dto.email.EmailDto;
import com.app.ecoplus.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("emails")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @GetMapping("/status")
    public ResponseEntity<String> emailTest(){
       return ResponseEntity.ok("O serviço de emails está funcionando!");
    }

    @PostMapping("/send")
    public ResponseEntity<String>sendEmail(@RequestBody EmailDto emailDto) {
        emailService.sendSimpleMessage(emailDto.getNomeCompleto(), emailDto.getEmpresa(),
        emailDto.getEmail(), emailDto.getCidade(), emailDto.getMensagem());

        return ResponseEntity.ok("Email enviado com sucesso!");

    }

}

