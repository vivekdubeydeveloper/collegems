package com.college.student.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.college.student.entity.KafkaTransaction;

public interface KafkaTransactionService {

	public KafkaTransaction getTransactionById(String transactionid);
}
