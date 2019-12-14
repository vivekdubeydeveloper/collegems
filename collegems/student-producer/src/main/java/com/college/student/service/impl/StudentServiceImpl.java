package com.college.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.college.student.consumer.dao.KafkaTransactionDAO;
import com.college.student.consumer.dao.StudentDAO;
import com.college.student.entity.KafkaTransaction;
import com.college.student.entity.Student;
import com.college.student.exception.StudentNotFound;
import com.college.student.model.ResponseBean;
import com.college.student.service.StudentService;
import com.college.student.util.MessageConstant;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	KafkaTransactionDAO ktDAO;
	
	private Supplier<String> tIdGenerator=()->UUID.randomUUID().toString();
	
	@Override
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		studentDAO.findAll().forEach(s->students.add(s));
		return students;
	}
	
	
	@Override
	public Student getStudent(int id) {
		return studentDAO.findById(id).orElseThrow(()->new StudentNotFound(MessageConstant.NO_SUBJECT_FOUND));
	}
	
	
	@Override
	public ResponseBean addUpdateStudent(Student student,String topic) {
		ResponseBean rb=new ResponseBean();
		String transactionId=tIdGenerator.get();
		KafkaTransaction kt=saveKafkaTransaction(transactionId);
		
		
		student.setTransactionId(transactionId);
		ListenableFuture<SendResult<String, Student>>  future=kafkaTemplate.send(topic,student);
		
		future.addCallback( new ListenableFutureCallback<SendResult<String, Student>>() {
			
			
			
			@Override
			public void onSuccess(SendResult<String, Student> result) {
				kt.setStatus(MessageConstant.KAFKA_TRANSACTION_COMPLETED);
				ktDAO.save(kt);
			}

			@Override
			public void onFailure(Throwable ex) {
				kt.setStatus(MessageConstant.KAFKA_TRANSACTION_FAILED);
				ktDAO.save(kt);
			}
			
		});
		
		
		String msg=MessageConstant.DATA_PUSHED_IN_KAFKA+student.getTransactionId();
		rb.setMsg(msg);;
		return rb;
	}

	
	
	

	@Override
	public ResponseBean deleteStudentById(Student student,String topic) {
		ResponseBean rb=new ResponseBean();
		String transactionId=tIdGenerator.get();
		KafkaTransaction kt=saveKafkaTransaction(transactionId);
		
		
		student.setTransactionId(transactionId);
		ListenableFuture<SendResult<String, Student>>  future=kafkaTemplate.send(topic,student);
		
		future.addCallback( new ListenableFutureCallback<SendResult<String, Student>>() {
			
			
			
			@Override
			public void onSuccess(SendResult<String, Student> result) {
				System.out.println("Success Method Call");
				kt.setStatus(MessageConstant.KAFKA_TRANSACTION_COMPLETED);
				ktDAO.save(kt);
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Fail Method Call");
				kt.setStatus(MessageConstant.KAFKA_TRANSACTION_FAILED);
				ktDAO.save(kt);
			}
			
		});
		
		
		String msg=MessageConstant.DATA_PUSHED_IN_KAFKA+student.getTransactionId();
		rb.setMsg(msg);;
		return rb;
	}
	
	
	private KafkaTransaction saveKafkaTransaction(String transactionId) {
		KafkaTransaction kt=new KafkaTransaction();
		kt.setTransactionId(transactionId);
		ktDAO.save(kt);
		return kt;
	}
	
	

	/*@Async
	@Override
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<>();
		System.out.println("Sending msg to kafka "+fetchStudentTopic);
			Student student=new Student();
			student.setTransactionId(tIdGenerator.get());
			ListenableFuture<SendResult<String, Student>>  future=kafkaTemplate.send(fetchStudentTopic,student);
	        future.addCallback(new ListenableFutureCallback<SendResult<String, Student>>(){

				@Override
				public void onSuccess(SendResult<String, Student> result) {
					// TODO Auto-generated method stub
					System.out.println(result.getRecordMetadata().offset());
				}

				@Override
				public void onFailure(Throwable ex) {
					// TODO Auto-generated method stub
					System.out.println("Unable to send the message");
				}
	        	
	        });
		System.out.println("completed ");
		return students;
	}*/

	/*

	*/

}