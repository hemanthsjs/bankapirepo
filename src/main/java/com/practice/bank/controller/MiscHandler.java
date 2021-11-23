package com.practice.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bank.pojos.Transaction;
import com.practice.bank.services.miscfunctions.MiscRootInterface;

@RestController
public class MiscHandler {
	
	@Autowired
	List<MiscRootInterface> misc_implementations_list;
	MiscRootInterface specific_implementation;

	@GetMapping("/print_transactions/{accnum}")
	public List<Transaction> printTransac(@PathVariable int accnum){
		int i=0;
		for (MiscRootInterface miscRootInterface : misc_implementations_list) {
			if(miscRootInterface.getClass().getName().contains("PrintTransactions")) {
				break;
			}
			else{i++;}
			
		}
		specific_implementation = misc_implementations_list.get(i);
		return specific_implementation.printList(accnum);
	}
}
