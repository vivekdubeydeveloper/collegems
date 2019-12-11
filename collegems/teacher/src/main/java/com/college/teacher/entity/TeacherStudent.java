package com.college.teacher.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="teacher_student")
public class TeacherStudent {
	
	@EmbeddedId
	TeacherStudentPK teacherStudentPK;

	public TeacherStudentPK getTeacherStudentPK() {
		return teacherStudentPK;
	}

	public void setTeacherStudentPK(TeacherStudentPK teacherStudentPK) {
		this.teacherStudentPK = teacherStudentPK;
	}

}
