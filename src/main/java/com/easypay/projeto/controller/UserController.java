package com.easypay.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easypay.projeto.dto.UserCreate;
import com.easypay.projeto.dto.UserUpdate;
import com.easypay.projeto.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;
    
    @GetMapping("/")
    public ResponseEntity exibirTodosUsuarios(){
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirUser(@PathVariable long id){
        return service.getUser(id);
    }

    @PostMapping("/")
    public ResponseEntity criaruser(@RequestBody @Valid UserCreate dados){
        return service.createUser(dados);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity desativarUser(@PathVariable long id){
        return service.deleteUser(id);
    }

    @PutMapping("/")
    public ResponseEntity atualizarUser(@RequestBody @Valid UserUpdate dados){
        return service.updateUser(dados);
    }


    //TESTES

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity exibirPorCPF(@PathVariable String cpf){
        return service.getByCPF(cpf);
    }
}
