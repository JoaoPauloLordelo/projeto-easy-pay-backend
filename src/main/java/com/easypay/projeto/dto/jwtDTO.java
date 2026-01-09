package com.easypay.projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record jwtDTO(   
    @NotBlank
    String tokenJWT

) {
    
}
