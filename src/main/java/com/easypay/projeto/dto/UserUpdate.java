package com.easypay.projeto.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record UserUpdate(

    @NotNull
    long id,

    @Nullable
    String nome,

    @Nullable
    String cpf
) {
    
}
