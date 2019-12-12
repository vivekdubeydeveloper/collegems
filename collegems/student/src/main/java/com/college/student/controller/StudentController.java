package com.college.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.college.student.entity.Student;
import com.college.student.model.ResponseBean;
import com.college.student.service.StudentService;
import com.college.student.util.MessageConstant;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	
	@GetMapping("/students/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}
	
	
	@PostMapping("/students")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseBean addStudent(@RequestBody Student student) {
		studentService.addUpdateStudent(student);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_CREATED_SUCCESSFULLY+student.getRollno());
		return rb;
	}
	
	
	@PutMapping("/students")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean updateStudent(@RequestBody Student student) {
		studentService.addUpdateStudent(student);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY);
		return rb;
	}
	
	
	@DeleteMapping("/students/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean deleteStudentById(@PathVariable("id") int id) {
		studentService.deleteStudentById(id);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_DELETED_SUCCESSFULLY);
		return rb;
	}
}
