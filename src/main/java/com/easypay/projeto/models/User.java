package com.easypay.projeto.models;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.easypay.projeto.dto.UserCreate;
import com.easypay.projeto.dto.UserUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Table(name= "usuario")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private String senha;
    private Boolean ativo;
    private Double saldo;

    @Enumerated
    private TypeUser tipo;

    public User(UserCreate dadoUser){
        this.nome = dadoUser.nome();
        this.cpf = dadoUser.cpf();
        this.idade = dadoUser.idade();
        this.email = dadoUser.email();
        this.senha = dadoUser.senha();
        this.tipo = dadoUser.tipo();
        this.ativo = true;
        this.saldo = 0.0;
    }

    public void setSenha(String senhaNova){
        this.senha = senhaNova;
    }

    public void desativar(){
        this.ativo = false;
    }

    public void reativar(){
        this.ativo = true;
    }

    public void atualizar(UserUpdate dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.cpf() != null){
            this.cpf = dados.cpf();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    
    @Override
    public boolean isAccountNonExpired() {
      return ativo;
    }
    
    @Override               
   public boolean isAccountNonLocked() {
      return ativo;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return ativo;
   }

   @Override
   public boolean isEnabled() {
      return ativo;
   }

}
