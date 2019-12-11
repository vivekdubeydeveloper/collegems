package com.college.teacher.entity;

import javax.persistence.Embeddable;

@Embeddable
public class TeacherStudentPK {
	private int teacherId;
	private int subjectId;
	
	public TeacherStudentPK(int teacherId, int subjectId) {
		this.teacherId = teacherId;
		this.subjectId = subjectId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	

}
