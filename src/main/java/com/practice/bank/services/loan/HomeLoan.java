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
public class HomeLoan implements LoanInterface, AccountDepositInterface {

	@Autowired
	TransactionRepository tr;
	@Autowired
	CustomerRepository cr;

	@Override
	public double calculateEmi(double interest, double principle, double years) {
		// TODO Auto-generated method stub
		double i = (principle * (interest / (100 * 12)) * Math.pow(((interest / 100 * 12) + 1), (years * 12)))
				/ (Math.pow(((interest / 100 * 12) + 1), (years * 12)) - 1);
		return i;
	}

	@Override
	public String deposit(double amount, int accnum) {

		double b = 0.00;
		Optional<CustomerEntity> c = cr.findById(accnum);
		List<TransactionEntity> te = tr.getTransactionList(accnum);
		TransactionEntity tk = new TransactionEntity();
		if (te.size() == 0) {

			tk.setBalance(amount);

		} else {
			int m = te.size() - 1;
			double n = te.get(m).getBalance();
			b = n + amount;
			tk.setBalance(b);
		}
		tk.setCustomer(c.get());
		tk.setCredit(amount);
		tk.setRemarks(amount + " Rs of home loan sanctioned.");
		tr.saveAndFlush(tk);
		return tk.getRemarks();
	}

}
