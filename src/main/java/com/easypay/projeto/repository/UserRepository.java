package com.easypay.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.easypay.projeto.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    public UserDetails findByCpf(String cpf);
}
