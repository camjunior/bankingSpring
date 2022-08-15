package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountCalculationControllerTest {

    @InjectMocks
    AccountCalculationController accountCalculationController;

    @Mock
    AccountRepository accountRepository;

    @Mock
    TransactionRepository transactionRepository;


    @Test
    void deposit() throws Exception {
        Account accountTest = new Account(1,10,100.00);
        List<Account> list = new ArrayList<>();
        list.add(accountTest);

        System.out.println("Old balance: " + accountTest.getBalance());
        System.out.println("Deposit: 50");

        when(accountRepository.findById(1)).thenReturn(Optional.of(accountTest));
        //TEST FOR DEPOSIT
        accountCalculationController.deposit(1,50);

        System.out.println("New balance: " + accountTest.getBalance());

        assertEquals(150.00,accountTest.getBalance() );


    }
}