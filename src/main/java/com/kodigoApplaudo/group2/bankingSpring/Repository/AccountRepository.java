package com.kodigoApplaudo.group2.bankingSpring.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value="SELECT * FROM Accounts a WHERE a.customer_id=?1", nativeQuery = true)
    List<Account> findByCustomerId(int id);

    @Query(value="SELECT * FROM Accounts a WHERE a.account_id=?1", nativeQuery = true)
    Optional<Account> findById(int id);

}
