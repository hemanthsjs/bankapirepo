package com.practice.bank.services.loan;

import org.springframework.stereotype.Service;

import com.practice.bank.services.freqtransactions.AccountDepositInterface;

@Service
public class HomeLoan implements LoanInterface,AccountDepositInterface {

	@Override
	public double calculateEmi(double interest, double principle, double years) {
		// TODO Auto-generated method stub
		double i = (principle*(interest/(100*12))*Math.pow(((interest/100*12)+1),(years*12)))/
				(Math.pow(((interest/100*12)+1),(years*12))-1);
		return i;
	}

	@Override
	public String deposit(double amount) {
		// TODO Auto-generated method stub
		return "Home loan EMI is "+Math.round(amount);
	}

}
