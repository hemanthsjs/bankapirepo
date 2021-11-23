package com.practice.bank.services.freqtransactions;

public interface AccountDepositInterface extends AccountRootInterface {
	
	String deposit(double amount, int accnum);

}
