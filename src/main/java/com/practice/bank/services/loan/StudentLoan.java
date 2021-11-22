package com.practice.bank.services.loan;

import org.springframework.stereotype.Service;

import com.practice.bank.services.freqtransactions.AccountDepositInterface;

@Service
public class StudentLoan implements LoanInterface,AccountDepositInterface {

	@Override
	public double calculateEmi(double principle, double interest, double years) {
		double i = (principle*(interest/(100*12))*Math.pow(((interest/100*12)+1),(years*12)))/
				(Math.pow(((interest/100*12)+1),(years*12))-1);
		
		return i;
	}

	@Override
	public String deposit(double amount) {
		// TODO Auto-generated method stub
		return "Student loan EMI is "+Math.round(amount);
	}

}
