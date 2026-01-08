package com.easypay.projeto.dto;

import com.easypay.projeto.models.TypeUser;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserCreate(

    @NotBlank
    String nome,

    @NotBlank
    String cpf,

    @Min(18)
    int idade,

    @NotBlank
    String email,

    @NotBlank
    String senha,

    TypeUser tipo
) {
    
}
