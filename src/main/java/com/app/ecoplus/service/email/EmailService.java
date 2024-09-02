package com.app.ecoplus.service.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendSimpleMessage( String nomeCompleto, String empresa, String email, String cidade, String mensagem ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(nomeCompleto);

        String corpoMensagem = "Nome Completo: " + nomeCompleto + "\n" +
                               "Empresa: " + empresa + "\n" +
                               "Cidade: " + cidade + "\n" +
                               "Mensagem: " + mensagem;

        message.setText(corpoMensagem);
        mailSender.send(message);


    }


}
