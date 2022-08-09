package com.kodigoApplaudo.group2.bankingSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByUsername(String username);
}
