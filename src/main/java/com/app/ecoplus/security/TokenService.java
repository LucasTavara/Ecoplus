package com.app.ecoplus.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.ecoplus.entity.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TokenService {

@Value("${api.security.token.secret}")
private String secret;


public String generateToken(User user) {

    try {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("Ecoplus")
                .withSubject(user.getEmail())
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