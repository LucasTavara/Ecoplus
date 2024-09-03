package com.app.ecoplus.security;

import com.app.ecoplus.dto.user.UserDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TokenService {

@Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {

        try {
            UserDto userDto = new UserDto();
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("Ecoplus")
                    .withSubject(userDto.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);

        }
        catch (JWTCreationException exception) {
            throw new RuntimeException("Erro de Autenticação");
        }
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Ecoplus")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception) {
            return null;
        }
    }


    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    }