package com.app.ecoplus.controller.email;


import com.app.ecoplus.dto.email.EmailDto;
import com.app.ecoplus.service.email.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String>sendEmail(@RequestBody @Valid EmailDto emailDto) {
        emailService.sendSimpleMessage(emailDto.getNomeCompleto(), emailDto.getEmpresa(),
        emailDto.getEmail(), emailDto.getCidade(), emailDto.getMensagem());

        return ResponseEntity.ok("Email enviado com sucesso!");

    }
}

