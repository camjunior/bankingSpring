package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionHistoryController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/getTransactionHistory")
    public List<Transaction> getTransactionHistory(@RequestParam(name="account_id") int account_id){
        return transactionRepository.findByAccountId(account_id);
    }
}
