package com.practice.bank.services.accounts;

import org.springframework.stereotype.Service;

import com.practice.bank.pojos.Customer;

@Service
public class SavingsAccount implements AccountsRootInterface{

	@Override
	public String createAccount(Customer c) {
		// TODO Auto-generated method stub
		return "Savings account created";
	}

}
