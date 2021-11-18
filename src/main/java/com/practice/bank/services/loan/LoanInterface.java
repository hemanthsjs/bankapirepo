package com.practice.bank.services.loan;

public interface LoanInterface extends LoanRootInterface {
	
	double calculateLoan(double principle, double interest, double years);

}
