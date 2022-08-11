package com.kodigoApplaudo.group2.bankingSpring.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(int account_id, double amount, TransactionType transactionType){
        Transaction transaction = new Transaction();
        transaction.setAccount_id(account_id);
        transaction.setBalance(amount);
        transaction.setTransact_type(transactionType);
        Date dt = new Date();

        transaction.setTransact_date(dt);
        transaction.setTransact_time(dt);

        transactionRepository.save(transaction);


    }



}
