package com.college.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.entity.KafkaTransaction;
import com.college.student.service.KafkaTransactionService;

@RestController
public class KafkaTransactionController {
	
	@Autowired
	KafkaTransactionService kafkaTransactionService;
	
	@GetMapping("/transactions/{transactionid}")
	public KafkaTransaction getTransactionById(@PathVariable("transactionid") String transactionid) {
		return kafkaTransactionService.getTransactionById(transactionid);
	}

}
