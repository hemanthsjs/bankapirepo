package com.practice.bank.services.freqtransactions;

import org.springframework.stereotype.Service;

@Service
public class SavingsDepositAndWithdrawl implements AccountDepositInterface, AccountWithdrawInterface {

	@Override
	public String withdraw(double amount) {
		// TODO Auto-generated method stub
		return  "Amount Withdrawn!";
	}

	@Override
	public String deposit(double amount) {
		// TODO Auto-generated method stub
		return  "Amount Deposited!";
	}

}
