package com.college.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.student.model.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		Student student=new Student();
		student.setId(1);
		student.setName("Vivek");
		return student;
	}

}
