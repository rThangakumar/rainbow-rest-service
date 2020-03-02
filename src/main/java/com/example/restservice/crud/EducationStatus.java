package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EducationStatus")
public class EducationStatus {
	
	private int educationStatusId;
	private String educationStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EducationStatusId")
	public int getEducationStatusId() {
		return educationStatusId;
	}
	public void setEducationStatusId(int educationStatusId) {
		this.educationStatusId = educationStatusId;
	}
	
	@Column(name="EducationStatus")
	public String getEducationStatus() {
		return educationStatus;
	}
	public void setEducationStatus(String educationStatus) {
		this.educationStatus = educationStatus;
	}

}
