package com.practice.bank.services.loan;

public interface LoanInterface extends LoanRootInterface {
	
	double calculateEmi(double principle, double interest, double years);

}
