package com.practice.bank.services.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.pojos.Customer;
import com.practice.bank.services.DTOobjects.CustomerEntity;
import com.practice.bank.services.DTOobjects.CustomerRepository;

@Service
public class SavingsAccount implements AccountsRootInterface{
	
	@Autowired
	CustomerRepository cr;

	@Override
	public String createAccount(Customer c) {
		CustomerEntity centity = new CustomerEntity();
		centity.setAadharNumber(c.getAadharNumebr());
		centity.setAccType(c.getAccType());
		centity.setAddress(c.getAddress());
		centity.setEmailId(c.getEmailId());
		centity.setName(c.getName());
		centity.setPhNumber(c.getPhoneNumber());
		cr.saveAndFlush(centity);
		c.setAccNumber(centity.getAccNumber());
		// TODO Auto-generated method stub
		return "Savings account created. Account number is "+c.getAccNumber();
	}

}
