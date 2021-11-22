package com.practice.bank.services.freqtransactions;

public interface AccountWithdrawInterface extends AccountRootInterface{
	
	String withdraw(double amount, int accnum);
	
	
}
