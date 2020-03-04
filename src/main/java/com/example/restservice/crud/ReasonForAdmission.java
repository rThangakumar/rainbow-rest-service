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

	private Integer reasonForAdmissionId;
	private String reasonForAdmission;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RFAID")
	public Integer getReasonForAdmissionId() {
		return reasonForAdmissionId;
	}
	public void setReasonForAdmissionId(Integer reasonForAdmissionId) {
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
