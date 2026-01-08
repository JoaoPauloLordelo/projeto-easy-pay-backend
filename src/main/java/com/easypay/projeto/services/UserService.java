package com.easypay.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easypay.projeto.dto.UserCreate;
import com.easypay.projeto.dto.UserListagem;
import com.easypay.projeto.dto.UserUpdate;
import com.easypay.projeto.models.User;
import com.easypay.projeto.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity getUser(long id){
        // UserListagem user = new UserListagem(repository.getReferenceById(id));
        User user = repository.getReferenceById(id);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(repository.findAll().stream().map(user -> new UserListagem(user)));
    }

    //REMOVER METODO GETBYPCF
    public ResponseEntity getByCPF(String cpf){
        UserDetails user = repository.findByCpf(cpf);
        return ResponseEntity.ok(user);

    }

    @Transactional
    public ResponseEntity createUser(UserCreate dados){
        User user  = new User(dados);
        user.setSenha(encoder.encode(dados.senha()));
        repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserListagem(user));

    }

    @Transactional
    public ResponseEntity deleteUser(long id){
        User user = repository.getReferenceById(id);
        user.desativar();
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity updateUser(UserUpdate dados){
        User user = repository.getReferenceById(dados.id());
        user.atualizar(dados);
        return ResponseEntity.ok().body(dados);
    }
}
