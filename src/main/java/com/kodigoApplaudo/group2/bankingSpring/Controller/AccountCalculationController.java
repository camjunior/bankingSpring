package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountCalculationController {

  @Autowired private AccountRepository accountRepository;
  @Autowired private TransactionService transactionService;

  @PostMapping("/depositAccount")
  public void deposit(@RequestParam Map<String, String> requestParams) throws Exception {
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
    transactionService.addTransaction(
        account1.getAccount_id(), Double.parseDouble(depositAmount), TransactionType.DEPOSIT);
  }
}
