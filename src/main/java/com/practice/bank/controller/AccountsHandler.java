package com.practice.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.services.accounts.AccountDepositInterface;
import com.practice.bank.services.accounts.AccountRootInterface;
import com.practice.bank.services.accounts.AccountWithdrawInterface;

@RestController
public class AccountsHandler {
	
	@Autowired
	List<AccountRootInterface> account_root_ref;
	AccountRootInterface specific_account_ref;
	
	@GetMapping("/fixedDeposit/{amount}")
	public String fixedAccount(@PathVariable double amount) {
		int i=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("FixedDepositAccount")) {
				break;
			}
			i++;
		}
		specific_account_ref = account_root_ref.get(i);
		return ((AccountDepositInterface) specific_account_ref).deposit(amount);
	}
	
	
	@GetMapping("/savingsWithdraw/{amount}")
	public String savingsWithdraw(@PathVariable double amount) {
		int j=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("SavingsAccount")) {
				break;
			}
				j++;
		}
		specific_account_ref = account_root_ref.get(j);
		return ((AccountWithdrawInterface) specific_account_ref).withdraw(amount);
	
	}
	
	@GetMapping("/savingsDeposit/{amount}")
	public String savingsDeposit(@PathVariable double amount) {
		int k=0;
		for (AccountRootInterface accountRootInterface : account_root_ref) {
			if(accountRootInterface.getClass().getName().contains("SavingsAccount")) {
				break ;
			}
			else {
				k++
			;}
		}
		specific_account_ref = account_root_ref.get(k);
		return ((AccountDepositInterface) specific_account_ref).deposit(amount);
	
	}
}
