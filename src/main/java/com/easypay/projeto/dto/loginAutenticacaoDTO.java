package com.easypay.projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record loginAutenticacaoDTO(
    
    @NotBlank
    String login,

    @NotBlank
    String senha
) {
    
}
