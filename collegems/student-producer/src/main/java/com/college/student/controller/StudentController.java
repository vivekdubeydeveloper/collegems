package com.college.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Value("${topic.create.student}")
	String createStudentTopic;
	
	@Value("${topic.update.student}")
	String updateStudentTopic;
	
	@Value("${topic.delete.student.id}")
	String deleteStudentTopic;
	
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
		return studentService.addUpdateStudent(student,createStudentTopic);
	}
	
	
	@PutMapping("/students")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean updateStudent(@RequestBody Student student) {
		return studentService.addUpdateStudent(student,updateStudentTopic);
	}
	
	@DeleteMapping("/students/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean deleteStudentById(@PathVariable("id") int id) {
		Student student=new Student();
		student.setRollno(id);
		return studentService.deleteStudentById(student,deleteStudentTopic);
	}
	
	
	
}
