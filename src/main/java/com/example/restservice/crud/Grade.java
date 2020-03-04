package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRADE")
public class Grade {
	
	private Long gradeId;
	private String grade;
	private String gradeCode;
	
	@Id
	@Column(name="GRADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getGradeId() {
		return gradeId;
	}
	
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	
	@Column(name="GRADE")
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Column(name="GRADE_CODE")
	public String getGradeCode() {
		return gradeCode;
	}
	
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

}