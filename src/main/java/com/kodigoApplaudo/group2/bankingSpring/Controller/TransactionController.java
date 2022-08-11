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
    @Operation(summary="Create a new deposit by id")
    public Account deposit(double amount, @PathVariable("id") Long id) throws Exception {
        return transactionService.deposit(amount, id);
    }

    @PostMapping("/withdraw/{id}")
    @Operation(summary="Generate a new withdraw by id")
    public Account withdraw(BigDecimal amount, @PathVariable("id") Long id) throws Exception {
        return transactionService.withdraw(amount, id);
    }
    */
}
