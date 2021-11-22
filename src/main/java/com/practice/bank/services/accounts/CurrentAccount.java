package com.practice.bank.services.accounts;

import org.springframework.stereotype.Service;

import com.practice.bank.pojos.Customer;

@Service
public class CurrentAccount implements AccountsRootInterface{

	@Override
	public String createAccount(Customer c) {
		// TODO Auto-generated method stub
		return "Current account created";
	}

}
