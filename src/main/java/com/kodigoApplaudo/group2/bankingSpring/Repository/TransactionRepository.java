package com.kodigoApplaudo.group2.bankingSpring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value="SELECT * FROM Transactions a WHERE a.account_id=?1", nativeQuery = true)
    List<Transaction> findByAccountId(int id);
}
