package com.college.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.teacher.entity.Teacher;
import com.college.teacher.model.ResponseBean;
import com.college.teacher.service.TeacherService;
import com.college.teacher.util.MessageConstant;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/teachers")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Teacher> getTeachers() {
		return teacherService.getTeachers();
	}

	@GetMapping("/teachers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Teacher getTeacher(@PathVariable("id") int id) {
		return teacherService.getTeacher(id);
	}

	@PostMapping("/teachers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseBean addTeacher(@RequestBody Teacher teacher) {
		teacherService.addUpdateTeacher(teacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_CREATED_SUCCESSFULLY + teacher.getEmpid());
		return rb;
	}

	@PutMapping("/teachers")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseBean updateTeacher(@RequestBody Teacher teacher) {
		teacherService.addUpdateTeacher(teacher);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY);
		return rb;
	}

	@DeleteMapping("/teachers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseBean deleteTeacherById(@PathVariable("id") int id) {
		teacherService.deleteTeacherById(id);
		ResponseBean rb = new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_DELETED_SUCCESSFULLY);
		return rb;
	}

}
