package com.kodigoApplaudo.group2.bankingSpring.Services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;

public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Account deposit(BigDecimal amount, long id) throws Exception {
        Optional<Account> opAccount = accountRepository.findById(id);

        if (opAccount.isPresent()) {
            Account account = opAccount.get();

            Transaction transaction = new Transaction();

            transaction.setAccount(account);
            transaction.setTransactionType(TransactionType.DEPOSIT);
            transaction.setAmount(amount);
            transactionRepository.saveAndFlush(transaction);

            account.setBalance(account.getBalance().add(transaction.getAmount()));
            return accountRepository.saveAndFlush(account);
        } else {
            throw new Exception();
        }

    }

    public Account withdraw(BigDecimal amount, long id) throws Exception {

        Optional<Account> opAccount = accountRepository.findById(id);

        if (opAccount.isPresent()) {
            Account account = opAccount.get();

            Transaction transaction = new Transaction();

            transaction.setAccount(account);
            transaction.setTransactionType(TransactionType.DEPOSIT);
            transaction.setAmount(amount);
            transactionRepository.saveAndFlush(transaction);

            account.setBalance(account.getBalance().subtract(transaction.getAmount()));
            return accountRepository.saveAndFlush(account);
        } else {
            throw new Exception();
        }

    }

}
