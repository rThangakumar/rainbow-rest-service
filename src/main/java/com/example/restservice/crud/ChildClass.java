package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "Studyingclass")
public class ChildClass {
	
	/*
	 * StudyingclassId Studyingclass status
	 */

	private int studyingclassId;
	private String studyingclass;
	private int status;

	public ChildClass() {

	}

	
	@Id
	@Column(name="StudyingclassId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStudyingclassId() {
		return studyingclassId;
	}

	public void setStudyingclass(String studyingclass) {
		this.studyingclass = studyingclass;
	}
	
	public String getStudyingclass() {
		return this.studyingclass;
	}

	/*
	 * @Column(name="status") public int getStatus() { return status; }
	 */


	public void setStatus(int status) {
		this.status = status;
	}


	public void setStudyingclassId(int studyingclassId) {
		this.studyingclassId = studyingclassId;
	}
	


}