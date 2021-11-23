package com.practice.bank.services.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.services.DTOobjects.CustomerEntity;
import com.practice.bank.services.DTOobjects.CustomerRepository;
import com.practice.bank.services.DTOobjects.TransactionEntity;
import com.practice.bank.services.DTOobjects.TransactionRepository;
import com.practice.bank.services.freqtransactions.AccountDepositInterface;

@Service
public class StudentLoan implements LoanInterface,AccountDepositInterface {

	
	@Autowired
	TransactionRepository tr;
	@Autowired
	CustomerRepository cr;
	
	
	@Override
	public double calculateEmi(double principle, double interest, double years) {
		double i = (principle*(interest/(100*12))*Math.pow(((interest/100*12)+1),(years*12)))/
				(Math.pow(((interest/100*12)+1),(years*12))-1);
		return i;
	}

	@Override
	public String deposit(double amount,int accnum) {
		Optional<CustomerEntity> c = cr.findById(accnum);
		List<TransactionEntity> te = tr.getTransactionList(accnum);
		int n = te.size()-1;
		double b = te.get(n).getBalance()+amount;
		TransactionEntity tk = new TransactionEntity();
		tk.setBalance(b);
		tk.setCredit(amount);
		tk.setRemarks(b+" Rs of Student loan sanctioned.");
		return  tk.getRemarks();
	}

}
