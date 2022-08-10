package com.kodigoApplaudo.group2.bankingSpring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
