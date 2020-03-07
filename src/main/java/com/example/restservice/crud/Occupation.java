package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ChildStatus")
public class Occupation {
	
	private Integer occupationNumber;
	private String occupation;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OccupationNo")
	public Integer getOccupationNumber() {
		return occupationNumber;
	}
	public void setOccupationNumber(Integer occupationNumber) {
		this.occupationNumber = occupationNumber;
	}
	
	@Column(name="Occupation")
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}