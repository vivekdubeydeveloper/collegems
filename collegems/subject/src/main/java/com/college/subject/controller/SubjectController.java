package com.college.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.college.subject.entity.Subject;
import com.college.subject.model.ResponseBean;
import com.college.subject.service.SubjectService;
import com.college.subject.util.MessageConstant;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/subjects")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}
	
	
	@GetMapping("/subjects/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Subject getSubject(@PathVariable("id") int id) {
		return subjectService.getSubject(id);
	}
	
	
	@PostMapping("/subjects")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseBean addSubject(@RequestBody Subject subject) {
		subjectService.addUpdateSubject(subject);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_CREATED_SUCCESSFULLY+subject.getId());
		return rb;
	}
	
	
	@PutMapping("/subjects")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean updateSubject(@RequestBody Subject subject) {
		subjectService.addUpdateSubject(subject);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_UPDATED_SUCCESSFULLY);
		return rb;
	}
	
	
	@DeleteMapping("/subjects/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseBean deleteSubjectById(@PathVariable("id") int id) {
		subjectService.deleteSubjectById(id);
		ResponseBean rb=new ResponseBean();
		rb.setMsg(MessageConstant.OBJECT_DELETED_SUCCESSFULLY);
		return rb;
	}
	

}
