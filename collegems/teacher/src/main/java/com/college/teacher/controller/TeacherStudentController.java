package com.college.teacher.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.teacher.entity.Teacher;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.util.MessageConstant;

@RestController
@RequestMapping("/api/v1")
public class TeacherStudentController {

	/*@PutMapping("/teachers/{id}/subjects")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseBean addTeacherSubject(@RequestBody Teacher teacher, @PathVariable("id") int id) {
		Teacher dbTeacher = teacherService.getTeacher(id);
		dbTeacher.setSubjectId(teacher.getSubjectId());
		teacherService.addUpdateTeacher(dbTeacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.SUBJECT_UPDATED_SUCCESSFULLY + teacher.getEmpid());
		return rb;
	}*/
	
	// @LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
