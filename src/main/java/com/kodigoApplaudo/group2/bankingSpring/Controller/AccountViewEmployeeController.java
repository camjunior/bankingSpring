package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/view")
public class AccountViewEmployeeController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers-accounts")
    public String getList(@RequestParam(name="id", required=true) String id, Model model) {
        int customerId = Integer.valueOf(id);
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        model.addAttribute("accounts",accounts);
        return "accounts-employee-view";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(name="id", required=true) String id, Model model) {
        int customerId = Integer.valueOf(id);
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        model.addAttribute("accounts",accounts);

        model.addAttribute("id",customerId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        model.addAttribute("customerName",customer.get().getCustomer_name());
        return "accounts-employee-view";
    }

    @RequestMapping("/addAccount")
    @ResponseBody
    public void createAccount(int customer_id){
        Account account = new Account();
        account.setBalance(0);
        account.setCustomer_id(customer_id);
        accountRepository.save(account);
    }

}
