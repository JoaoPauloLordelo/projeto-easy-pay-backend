package com.easypay.projeto.dto;

import com.easypay.projeto.models.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserListagem(
    @NotNull
    Long id, 
    
    @NotBlank
    String nome, 
    
    @NotBlank
    String cpf,

    @NotNull
    boolean ativo,

    @NotBlank
    String senha
)
    {

    public UserListagem(User usuario){
        this(usuario.getId_user(),usuario.getNome(),usuario.getCpf(), usuario.getAtivo(), usuario.getSenha());
    }

} 
