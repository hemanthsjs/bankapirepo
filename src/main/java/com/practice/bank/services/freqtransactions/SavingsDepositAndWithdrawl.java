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
		Optional<CustomerEntity> c = cr.findById(accnum);
		List<TransactionEntity> te = tr.getTransactionList(accnum);
		int n = te.size()-1;
		double b = te.get(n).getBalance()-amount;
		TransactionEntity tk = new TransactionEntity();
		tk.setBalance(b);
		tk.setDebit(amount);
		tk.setRemarks(b+" Rs withdrawn.");
		return  tk.getRemarks();
	}

	@Override
	public String deposit(double amount, int accnum) {
		double b = 0.00;
		Optional<CustomerEntity> c = cr.findById(accnum);
		List<TransactionEntity> te = tr.getTransactionList(accnum);
		if(te.size()==0) {
			TransactionEntity tk = new TransactionEntity();
			tk.setBalance(amount);
			tk.setCredit(amount);
			tk.setRemarks(amount+" Rs Deposited.");
			tr.saveAndFlush(tk);
			return  tk.getRemarks();
		}
		else {
		double n = te.get(-1).getBalance();
//		if(n>0) {
//			b = te.get(n).getBalance()+amount;
//		} else {
//			 b = te.get(0).getBalance()+amount;
//		}
		b = n+amount;
		TransactionEntity tk = new TransactionEntity();
		tk.setBalance(b);
		tk.setCredit(amount);
		tk.setRemarks(b+" Rs Deposited.");
		tr.saveAndFlush(tk);
		return  tk.getRemarks();
	}

}
}
