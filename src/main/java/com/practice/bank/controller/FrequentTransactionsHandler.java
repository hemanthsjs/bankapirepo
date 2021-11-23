package com.practice.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.services.freqtransactions.AccountDepositInterface;
import com.practice.bank.services.freqtransactions.AccountRootInterface;
import com.practice.bank.services.freqtransactions.AccountWithdrawInterface;

@RestController
public class FrequentTransactionsHandler {
	
	@Autowired
	List<AccountRootInterface> account_root_ref;
	AccountRootInterface specific_account_ref;
	
	@PutMapping("/fixedDeposit/{accnum)/{amount}")
	public String fixedAccount(@PathVariable double amount, @PathVariable int accnum) {
		int i=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("FixedDepositAccount")) {
				break;
			}
			i++;
		}
		specific_account_ref = account_root_ref.get(i);
		return ((AccountDepositInterface) specific_account_ref).deposit(amount,accnum);
	}
	
	
	@PutMapping("/savingsWithdraw/{accnum}/{amount}")
	public String savingsWithdraw(@PathVariable double amount, @PathVariable int accnum) {
		int j=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("SavingsDepositAndWithdrawl")) {
				break;
			}
				j++;
		}
		specific_account_ref = account_root_ref.get(j);
		return ((AccountWithdrawInterface) specific_account_ref).withdraw(amount,accnum);
	
	}
	
	@PutMapping("/savingsDeposit/{accnum}/{amount}")
	public String savingsDeposit( @PathVariable int accnum, @PathVariable double amount) {
		int k=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("SavingsDepositAndWithdrawl")) {
				break ;
			}
			else {
				k++
			;}
		}
		specific_account_ref = account_root_ref.get(k);
		return ((AccountDepositInterface) specific_account_ref).deposit(amount,accnum);
	
	}
}
