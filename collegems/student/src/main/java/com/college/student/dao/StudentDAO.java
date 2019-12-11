package com.college.student.dao;

import org.springframework.data.repository.CrudRepository;

import com.college.student.entity.Student;

public interface StudentDAO extends CrudRepository<Student, Integer>{

}
