package com.practice.bank.services.freqtransactions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.services.DTOobjects.CustomerRepository;
import com.practice.bank.services.DTOobjects.TransactionEntity;
import com.practice.bank.services.DTOobjects.TransactionRepository;

@Service
public class FixedDepositAccount implements AccountDepositInterface {

	@Autowired
	TransactionRepository tr;
	@Autowired
	CustomerRepository cr;
	
	
	@Override
	public String deposit(double amount, int accnum) {
		TransactionEntity tk = new TransactionEntity();
		tk.setBalance(amount);
		tk.setCredit(amount);
		tk.setRemarks(amount+" Rs credited into fixed deposit.");
		return  tk.getRemarks();
	}

}
