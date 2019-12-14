package com.college.student.consumer.service;

import java.util.List;

import com.college.student.consumer.entity.Student;


public interface StudentService {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudentById(Student student);
}
