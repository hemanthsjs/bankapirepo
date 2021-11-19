package com.practice.bank.services.accounts;

import org.springframework.stereotype.Service;

@Service
public class FixedDepositAccount implements AccountDepositInterface {

	@Override
	public String deposit(double amount) {
		// TODO Auto-generated method stub
		return  "Amount put into fixed deposit!";
	}

}
