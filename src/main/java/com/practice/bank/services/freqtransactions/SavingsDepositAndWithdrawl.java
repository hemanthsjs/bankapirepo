package com.practice.bank.services.freqtransactions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.services.DTOobjects.CustomerEntity;
import com.practice.bank.services.DTOobjects.CustomerRepository;
import com.practice.bank.services.DTOobjects.TransactionEntity;
import com.practice.bank.services.DTOobjects.TransactionRepository;

@Service
public class SavingsDepositAndWithdrawl implements AccountDepositInterface, AccountWithdrawInterface {

	@Autowired
	TransactionRepository tr;
	@Autowired
	CustomerRepository cr;

	@Override
	public String withdraw(double amount, int accnum) {
		double b = 0.00;
		Optional<CustomerEntity> c = cr.findById(accnum);
		List<TransactionEntity> te = tr.getTransactionList(accnum);
		TransactionEntity tk = new TransactionEntity();
		if (te.size() == 0) {

			return "Insufficient balance!";

		} else {
			int m = te.size() - 1;
			double n = te.get(m).getBalance();
			b = n - amount;
			tk.setBalance(b);
		}
		tk.setCustomer(c.get());
		tk.setDebit(amount);
		tk.setRemarks(amount + " Rs Withdrawn.");
		tr.saveAndFlush(tk);
		return tk.getRemarks();
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
		tk.setRemarks(amount + " Rs Deposited.");
		tr.saveAndFlush(tk);
		return tk.getRemarks();
	}

}
