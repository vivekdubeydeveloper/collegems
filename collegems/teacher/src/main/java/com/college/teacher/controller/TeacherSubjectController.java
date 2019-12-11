package com.college.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.subject.entity.Subject;
import com.college.teacher.entity.Teacher;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

@RestController
public class TeacherSubjectController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/teachers/{id}/subjects")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Subject getTeacherSubject(@PathVariable("id") int id) {
		Teacher dbTeacher = teacherService.getTeacher(id);
		String url = "http://localhost:8080/subjects/" + dbTeacher.getSubjectId();
		Subject subject = restTemplate.getForObject(url, Subject.class);
		return subject;
	}

	@PutMapping("/teachers/{id}/subjects")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseBean addTeacherSubject(@RequestBody Teacher teacher, @PathVariable("id") int id) {
		Teacher dbTeacher = teacherService.getTeacher(id);
		dbTeacher.setSubjectId(teacher.getSubjectId());
		teacherService.addUpdateTeacher(dbTeacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.SUBJECT_UPDATED_SUCCESSFULLY + teacher.getEmpid());
		return rb;
	}

	// @LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
