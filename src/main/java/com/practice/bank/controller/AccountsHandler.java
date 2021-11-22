package com.practice.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.pojos.Customer;
import com.practice.bank.services.accounts.AccountsRootInterface;

@RestController
public class AccountsHandler {

	@Autowired
	List<AccountsRootInterface> accounts_interface;
	AccountsRootInterface specific_account;

	@PostMapping("/create_savings_account")
	public String savingsAccount(@RequestBody Customer c) {
		int i = 0;
		for (AccountsRootInterface accountsRootInterface : accounts_interface) {
			if (accountsRootInterface.getClass().getName().contains("SavingsAccount")) {
				break;
			}
			i++;
		}
		specific_account = accounts_interface.get(i);

		String s = specific_account.createAccount(c);
		return s;
	}
	
	
	
	
	
	@PostMapping("/create_current_account")
	public String currentAccount(@RequestBody Customer c) {
		int i = 0;
		for (AccountsRootInterface accountsRootInterface : accounts_interface) {
			if (accountsRootInterface.getClass().getName().contains("CurrentAccount")) {
				break;
			}
			i++;
		}
		specific_account = accounts_interface.get(i);

		String s = specific_account.createAccount(c);
		return s;
	}

}
