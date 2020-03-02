package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ReasonForAdmission")
public class ReasonForAdmission {

	private int reasonForAdmissionId;
	private String reasonForAdmission;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RFAID")
	public int getReasonForAdmissionId() {
		return reasonForAdmissionId;
	}
	public void setReasonForAdmissionId(int reasonForAdmissionId) {
		this.reasonForAdmissionId = reasonForAdmissionId;
	}
	
	@Column(name="RFA")
	public String getReasonForAdmission() {
		return reasonForAdmission;
	}
	public void setReasonForAdmission(String reasonForAdmission) {
		this.reasonForAdmission = reasonForAdmission;
	}
		
}
