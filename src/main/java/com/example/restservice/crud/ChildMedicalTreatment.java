package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildMedicalTreatment {
	
	public ChildMedicalTreatment() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childMedicalTreatmentNo;
	private Long childNo;
	private Date illnessStartDate;
	private Date visitedDate;
	private String hospitalName;
	private String doctorName;
	private String diseaseDiagnosed;
	private String furtherTests;
	private Long totalMedicalCost;
	private String remarks;
	public void setChildMedicalTreatmentNo(Integer childMedicalTreatmentNo) {
		this.childMedicalTreatmentNo = childMedicalTreatmentNo;
	}
}