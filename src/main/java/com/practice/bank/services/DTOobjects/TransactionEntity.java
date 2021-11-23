package com.practice.bank.services.DTOobjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions_table")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_ID")
	private int transaction_id;
	
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private CustomerEntity customer;
	
	
	@Column(name = "Credit")
	private double credit;
	
	@Column(name = "Debit")
	private double debit;
	
	@Column(name = "Remarks")
	private String remarks;
	
	private double balance;
	
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return transaction_id;
	}
	public void setId(int id) {
		this.transaction_id = id;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
