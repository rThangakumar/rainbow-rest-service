package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ReasonForAdmission")
public class ReasonForAdmission {

	private int reasonForAdmissionId;
	private String reasonForAdmission;
	
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
