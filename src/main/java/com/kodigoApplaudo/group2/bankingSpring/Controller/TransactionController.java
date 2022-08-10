package com.kodigoApplaudo.group2.bankingSpring.Controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;

public class TransactionController {

    private TransactionService transactionService;

    /*
    @PostMapping("/deposit/{idConta}")
    public Account deposit(double amount, @PathVariable("id") Long id) throws Exception {
        return transactionService.deposit(amount, id);
    }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(BigDecimal amount, @PathVariable("id") Long id) throws Exception {
        return transactionService.withdraw(amount, id);
    }
    */
}
