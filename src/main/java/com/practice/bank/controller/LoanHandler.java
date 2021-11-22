package com.practice.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.services.freqtransactions.AccountDepositInterface;
import com.practice.bank.services.loan.LoanInterface;
import com.practice.bank.services.loan.LoanRootInterface;

@RestController
public class LoanHandler {

	@Autowired
	List<LoanRootInterface> implementations_list;
	LoanRootInterface specific_implementation;
	
	
	
	
	

	@PutMapping("/student_loan/{accnum}/{principle}/{interest}/{years}")
	public String studentLoan(@PathVariable double principle, @PathVariable double interest,
			@PathVariable double years, @PathVariable int accnum) {
		int i = 0;
		for (LoanRootInterface loanRootInterface : implementations_list) {
			if (loanRootInterface.getClass().getName().contains("StudentLoan")) {
				
				break;
			} else {
			i++;}
		}
		specific_implementation = implementations_list.get(i);
		double l =  ((LoanInterface) specific_implementation).calculateEmi(interest, principle, years);
		return  ((AccountDepositInterface) specific_implementation).deposit(l,accnum);
	}

	
	
	
	
	
	@PutMapping("/home_loan/{accnum}/{principle}/{interest}/{years}")
	public String homeLoan(@PathVariable double principle, @PathVariable double interest, 
			@PathVariable double years, @PathVariable int accnum) {
		int j = 0;;
		for (LoanRootInterface loanRootInterface : implementations_list) {
			if (loanRootInterface.getClass().getName().contains("HomeLoan")) {
				break;
			}else {
			j++;}
		}
		specific_implementation = implementations_list.get(j);
		double l =  ((LoanInterface) specific_implementation).calculateEmi(interest, principle, years);
		return  ((AccountDepositInterface) specific_implementation).deposit(l,accnum);
	}

	}
	
