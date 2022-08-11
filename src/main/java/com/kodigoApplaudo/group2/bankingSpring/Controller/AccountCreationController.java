package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountCreationController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/createAccount")
    public String getHistory(@RequestParam(name="customer_id", required=true) int customer_id) {
        Account account = new Account();
        account.setCustomer_id(customer_id);
        account.setBalance(0);

        try {
            accountRepository.save(account);
        } catch (Exception e) {
            return "Failed. Unable to add new account. Check if customer exists";
        }

        Optional<Customer> customer = customerRepository.findById(customer_id);

        return "Success. New account added for " + customer.get().getCustomer_name()
                + " with customer id " + customer.get().getCustomer_id();
    }


}
