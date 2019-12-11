package com.college.student.service;

import java.util.List;

import com.college.student.entity.Student;

public interface StudentService {
	public List<Student> getStudents();
	public Student getStudent(int id);
	public void addUpdateStudent(Student student);
	public void deleteStudentById(int id);
}
