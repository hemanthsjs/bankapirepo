package com.practice.bank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.services.loan.LoanInterface;
import com.practice.bank.services.loan.LoanRootInterface;

@RestController
public class LoanHandler {
	
	@Autowired
	List<LoanRootInterface> implementations_list;
	LoanRootInterface specific_implementation;
	
	@GetMapping("/student_loan/{principle}/{interest}/{years}")
	public double studentLoan(@PathVariable double principle, @PathVariable double interest,
			@PathVariable double years) {
		specific_implementation = implementations_list.get(0);
		return ((LoanInterface) specific_implementation).calculateLoan(interest, principle, years);
	}
	
	@GetMapping("/home_loan/{principle}/{interest}/{years}")
	public double homeLoan(@PathVariable double principle, @PathVariable double interest,
			@PathVariable double years) {
		specific_implementation = implementations_list.get(1);
		return ((LoanInterface) specific_implementation).calculateLoan(interest, principle, years);
	}
	
	
}

