package com.easypay.projeto.services;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.easypay.projeto.dto.jwtDTO;
import com.easypay.projeto.models.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    
    @Value("${token.secret}")
    private String secretPass;

    public ResponseEntity criarToken(User usuario){


        try {
            // Algorithm algoritimo = Algorithm.HMAC256(System.getenv("API_KEY"));
            Algorithm algoritimo = Algorithm.HMAC256(secretPass);
            String token = JWT.create()
                .withIssuer("api-easy-pay")
                .withSubject(usuario.getCpf())
                .withClaim("id", usuario.getId_user())
                .withExpiresAt(dataExpiracao())
                .sign(algoritimo);

            return ResponseEntity.ok(new jwtDTO(token)); 
            } catch (JWTCreationException exception){

                throw new RuntimeException("Erro ao gerar token",exception);                
            }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00"));
    }
    
}
