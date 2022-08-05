package com.kodigoApplaudo.group2.bankingSpring.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
