package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Account;
import com.kodigoApplaudo.group2.bankingSpring.Model.TransactionType;
import com.kodigoApplaudo.group2.bankingSpring.Repository.AccountRepository;
import com.kodigoApplaudo.group2.bankingSpring.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public String deposit(@RequestParam Map<String, String> requestParams) throws Exception {
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

    try{

      accountRepository.save(account1);
      transactionService.addTransaction(
              account1.getAccount_id(), Double.parseDouble(depositAmount), TransactionType.DEPOSIT);

      return "Deposit of " + depositAmount+ " successful. New balance: " + account1.getBalance();

    } catch (Exception e) {

      return "Error. Unable to add transaction. Please check input.";

    }

  }

  @PostMapping("/withdrawAccount")
  @ResponseBody
  public String withdraw(@RequestParam Map<String,String> requestParams) throws Exception{
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
      return "Withdraw successfull. New balance: " + account1.getBalance();
      //fin
    } else {

      return "Not enough money on account";

    }

  }
}
