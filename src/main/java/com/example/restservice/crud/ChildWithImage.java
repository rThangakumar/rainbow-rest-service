package com.example.restservice.crud;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildWithImage {

	private Long childNo;
	private String childStringId;
	private Integer rainbowHomeNumber;
	
	private String firstName;
	
	private String lastName;
	
	private Integer gender;
	
	private Date dateOfBirth;
	
	private Integer religion;
	
	private Integer community;
	
	private Integer motherTongue;
	
	private Integer parentalStatus;
	
	private String reasonForAdmission;
	
	private Integer educationStatus;
	
	private Date admissionDate;
	
	private Integer admittedBy;
	
	private String referredBy;
	
	private String referredSource;
	
	private Integer childStatus;
	
	private String identificationMark1;
	
	private String identificationMark2;
	
	private Integer stayReason;
	
	private Integer occupation;
	
	private Integer differentlyAbledGroup;
	
	private Integer previousClassStudied;
	
	private String 	dropoutReason;

	private String duration;
	
	private String organisationName;
	
	private String cWCRefNo;
	
	private Integer bloodGroup;
	
	private MultipartFile file; 

	
	public ChildWithImage() {

	}

	public ChildWithImage(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
}