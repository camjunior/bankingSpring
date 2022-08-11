package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/view")
public class TransactionHistoryViewController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping("/transaction-history")
    public String getHistory(@RequestParam(name="id", required=true) String id, Model model) {
        int accountId = Integer.valueOf(id);
        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
        Optional<Account> account = accountRepository.findById(accountId);
        model.addAttribute("customerId",account.get().getCustomer_id());
        model.addAttribute("Transaction",transactions);
        return "transaction-history-view";
    }

    @RequestMapping("/transaction-history-employee-view")
    public String getHistoryForEmployee(@RequestParam(name="id", required=true) String id, Model model) {
        int accountId = Integer.valueOf(id);
        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
        Optional<Account> account = accountRepository.findById(accountId);
        model.addAttribute("customerId",account.get().getCustomer_id());
        model.addAttribute("Transaction",transactions);
        return "transaction-history-view-employee";
    }
}
