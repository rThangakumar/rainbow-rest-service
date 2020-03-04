package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Religion")
public class Religion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer religionId;
	private String religion;
	
	@Column(name="ReligionId")
	public Integer getReligionId() {
		return religionId;
	}
	public void setReligionId(Integer religionId) {
		this.religionId = religionId;
	}
	
	@Column(name="ReligionId")
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
}
