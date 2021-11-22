package com.practice.bank.services.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bank.pojos.Customer;
import com.practice.bank.services.DTOobjects.CustomerEntity;
import com.practice.bank.services.DTOobjects.CustomerRepository;

@Service
public class CurrentAccount implements AccountsRootInterface{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public String createAccount(Customer c) {
		if(c.getName()!=null && c.getAccType().contains("current")) {
			
		CustomerEntity centity = new CustomerEntity();
		centity.setAadharNumber(c.getAadharNumber());
		centity.setAccType(c.getAccType());
		centity.setAddress(c.getAddress());
		centity.setEmailId(c.getEmailId());
		centity.setName(c.getName());
		centity.setPhNumber(c.getPhoneNumber());
		cr.saveAndFlush(centity);
		c.setAccNumber(centity.getId());
		}
		else {
			return "Not a current account!";
		}
		return "Current account created. Account number is "+c.getAccNumber();
	}

}
