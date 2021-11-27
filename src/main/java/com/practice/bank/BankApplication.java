package com.practice.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import ch.qos.logback.core.net.ssl.SSL;

@SpringBootApplication
@EnableAutoConfiguration
//@EntityScan(basePackages = {"com.practice.bank.services.DTOobjects"})
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
//		SpringApplication.run(SSL.class, args);
	}

}
