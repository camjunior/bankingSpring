package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.Transaction;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.TransactionRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/view")
public class AccountViewCustomerController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionService transactionService;

    @GetMapping("/my-accounts")
    public String getList(@RequestParam(name="id", required=true) String id, Model model) {
        int customerId = Integer.valueOf(id);
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        model.addAttribute("accounts",accounts);
        return "accounts-client-view";
    }

    @RequestMapping("/deposit")
    @ResponseBody //inicio
    public void deposit(@RequestParam Map<String,String> requestParams) throws Exception{
        String id = requestParams.get("account_id");
        String depositAmount = requestParams.get("depositAmount");
        int account_id = Integer.parseInt(id);

        Optional<Account> account = accountRepository.findById(account_id);
        double currentBalance = account.get().getBalance();
        BigDecimal oldBalance = new BigDecimal(Double.toString(currentBalance));
        BigDecimal deposit = new BigDecimal(depositAmount);
        deposit = deposit.setScale(2, RoundingMode.FLOOR);
        BigDecimal result = oldBalance.add(deposit);

        currentBalance = Double.parseDouble(result.toString());

        account.get().setBalance(currentBalance);
        Account account1 = account.get();

        accountRepository.save(account1);
        transactionService.addTransaction(account1.getAccount_id(),Double.parseDouble(depositAmount), TransactionType.DEPOSIT);

    }

    @RequestMapping("/withdraw")
    @ResponseBody
    public void withdraw(@RequestParam Map<String,String> requestParams) throws Exception{
        String id = requestParams.get("account_id");
        String withdrawAmount = requestParams.get("withdrawAmount");
        int account_id = Integer.parseInt(id);

        Optional<Account> account = accountRepository.findById(account_id);
        double currentBalance = account.get().getBalance();
        BigDecimal oldBalance = new BigDecimal(Double.toString(currentBalance));
        BigDecimal withdraw = new BigDecimal(withdrawAmount);
        withdraw = withdraw.setScale(2, RoundingMode.FLOOR);

        if (oldBalance.compareTo(withdraw) != -1){
            BigDecimal result = oldBalance.subtract(withdraw);

            currentBalance = Double.parseDouble(result.toString());

            account.get().setBalance(currentBalance);
            Account account1 = account.get();

            accountRepository.save(account1);
            transactionService.addTransaction(account1.getAccount_id(),Double.parseDouble(withdrawAmount), TransactionType.WITHDRAW);

            //fin
        }

    }




}
