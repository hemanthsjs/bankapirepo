package com.practice.bank.services.DTOobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_Table")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "Account_Number")
	private int id;
//	@Column(name = "Account_Number")
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long accNumber;
	@Column(name = "Name")
	private String name;
	@Column(name = "Email_ID")
	private String emailId;
	@Column(name = "Phone_Number")
	private String phNumber;
	@Column(name = "Aadhar_Number")
	private String aadharNumber;
	@Column(name = "Account_Type")
	private String accType;
	@Column(name = "Address")
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public long getAccNumber() {
//		return accNumber;
//	}
//	public void setAccNumber(long accNumber) {
//		this.accNumber = accNumber;
//	}
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
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
