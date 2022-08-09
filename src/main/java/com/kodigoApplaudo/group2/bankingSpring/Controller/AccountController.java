package com.kodigoApplaudo.group2.bankingSpring.Controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;

@Controller
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/form")
    public String accountForm(Account account) {

        return "addAccountForm";
    }

    @PostMapping("/add")
    public String newAccount(@Validated Account account, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/form";
        }

        accountRepository.save(account);

        return "redirect:/home";
    }

    @GetMapping("/balance/{id}")
    public BigDecimal checkBalance(@PathVariable("id") Long id) throws Exception {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.get().getBalance();
        } else {
            throw new Exception();
        }
    }

}
