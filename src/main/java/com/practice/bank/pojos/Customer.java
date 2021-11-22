package com.practice.bank.pojos;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private String name;
	private String emailId;
	private String phoneNumber;
	private String aadharNumebr;
	private String address;
	private long accNumber;
	private String accType;
	
	
	
	
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAadharNumebr() {
		return aadharNumebr;
	}
	public void setAadharNumebr(String aadharNumebr) {
		this.aadharNumebr = aadharNumebr;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
}
