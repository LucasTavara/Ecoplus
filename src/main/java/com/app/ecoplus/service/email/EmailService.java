package com.app.ecoplus.service.email;

import com.app.ecoplus.dto.FormDto;
import com.app.ecoplus.dto.email.EmailDto;
import jakarta.mail.internet.MimeMessage;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;


    public void sendEmail(FormDto emailDto ) {
       try{
           MimeMessage mimeMessage = mailSender.createMimeMessage();
           MimeMessageHelper help = new MimeMessageHelper(mimeMessage);

           help.setFrom("noreply@email.com");
           help.setSubject("Email Enviado!");
           help.setTo(emailDto.getEmail());

           String Template = LoadingTemplate();

           Template = Template.replace("#{nome}", emailDto.getEmpresa());
           help.setText(Template, true);
           mailSender.send(mimeMessage);


       }
       catch (Exception e){
           System.out.println("Falha ao enviar e-mail");
       }
    }


    public String LoadingTemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/Email/Email.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
