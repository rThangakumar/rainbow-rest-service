package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Identifications")
public class Identification {
	
	private long IdentificationId;
	private String Identification;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdentificationId() {
		return IdentificationId;
	}
	
	public void setIdentificationId(long identificationId) {
		IdentificationId = identificationId;
	}
	
	@Column(name="Identification")
	public String getIdentification() {
		return Identification;
	}
	
	public void setIdentification(String identification) {
		Identification = identification;
	}

}