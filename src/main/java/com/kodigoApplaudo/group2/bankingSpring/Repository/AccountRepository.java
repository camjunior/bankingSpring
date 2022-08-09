package com.kodigoApplaudo.group2.bankingSpring.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
