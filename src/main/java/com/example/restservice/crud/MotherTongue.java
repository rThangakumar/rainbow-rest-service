package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MotherTongue")
public class MotherTongue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MotherTongueId;
	private String MotherTongue;
	
	@Column(name="MotherTongueId")
	public Integer getMotherTongueId() {
		return MotherTongueId;
	}
	public void setMotherTongueId(Integer motherTongueId) {
		MotherTongueId = motherTongueId;
	}
	
	@Column(name="MotherTongue")
	public String getMotherTongue() {
		return MotherTongue;
	}
	public void setMotherTongue(String motherTongue) {
		MotherTongue = motherTongue;
	}
	
	
	
}
