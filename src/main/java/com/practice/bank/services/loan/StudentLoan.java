package com.practice.bank.services.loan;

import org.springframework.stereotype.Service;

@Service
public class StudentLoan implements LoanInterface {

	@Override
	public double calculateLoan(double principle, double interest, double years) {
		double i = (principle*(interest/(100*12))*Math.pow(((interest/100*12)+1),(years*12)))/
				(Math.pow(((interest/100*12)+1),(years*12))-1);
		
		return i;
	}

}
