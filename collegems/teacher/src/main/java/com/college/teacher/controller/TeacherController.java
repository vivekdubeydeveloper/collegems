package com.college.teacher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.teacher.model.Teacher;

@RestController
public class TeacherController {
	
	@GetMapping("/teacher")
	public Teacher getTeacher() {
		Teacher teacher=new Teacher();
		teacher.setId(1);
		teacher.setName("Vivek");
		return teacher;
	}

}
