package com.college.subject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.subject.model.Subject;

@RestController
public class SubjectController {
	
	@GetMapping("/subject")
	public Subject getSubject() {
		Subject subject=new Subject();
		subject.setId(1);
		subject.setName("Ravi");
		return subject;
	}

}
