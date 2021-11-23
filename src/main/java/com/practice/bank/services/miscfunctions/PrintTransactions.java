package com.practice.bank.services.miscfunctions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.pojos.Customer;
import com.practice.bank.pojos.Transaction;
import com.practice.bank.services.DTOobjects.CustomerEntity;
import com.practice.bank.services.DTOobjects.CustomerRepository;
import com.practice.bank.services.DTOobjects.TransactionEntity;
import com.practice.bank.services.DTOobjects.TransactionRepository;


@Service
public class PrintTransactions implements MiscRootInterface {
	LocalDate dnt;
	
	@Autowired
	TransactionRepository tr;
	@Autowired
	CustomerRepository cr;
	
	
	public List<Transaction> printList(int accnum){
		CustomerEntity c = cr.getById(accnum);
		List<TransactionEntity> tl = tr.getTransactionList(accnum);
		List<Transaction> t = new ArrayList<Transaction>();
		
		for (TransactionEntity element : tl) {
			Transaction to = new Transaction();
			to.setCredit(element.getCredit());
			to.setDate(dnt.now());
			to.setDebit(element.getDebit());
			to.setRemarks(element.getRemarks());
			Customer ce = new Customer();
			ce.setAadharNumebr(element.getCustomer().getAadharNumber());
			ce.setAccNumber(element.getCustomer().getC_id());
			ce.setAccType(element.getCustomer().getAccType());
			ce.setAddress(element.getCustomer().getAddress());
			ce.setEmailId(element.getCustomer().getEmailId());
			ce.setName(element.getCustomer().getName());
			ce.setPhoneNumber(element.getCustomer().getPhNumber());
			to.setC(ce);
			t.add(to);
		}
		
		return t;
	}

}
