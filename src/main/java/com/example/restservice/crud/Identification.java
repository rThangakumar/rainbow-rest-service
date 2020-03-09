package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Identification")
public class Identification {
	
	private Integer identificationId;
	private String identification;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdentificationId")
	public Integer getIdentificationId() {
		return identificationId;
	}
	public void setIdentificationId(Integer identificationId) {
		this.identificationId = identificationId;
	}
	
	@Column(name="Identification")
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	

}
