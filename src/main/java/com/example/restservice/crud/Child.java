package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ChildBasic")
public class Child {

	private Long childNo;
	private String childStringId;
	private Integer rainbowHomeNumber;
	
	@Size(min=2, max=30)
	@NotEmpty(message = "First name must not be empty")
	private String firstName;
	
	@Size(min=2, max=30)
	@NotEmpty(message = "Last name must not be empty")
	private String lastName;
	
	@NotEmpty(message = "Gender must not be empty")
	private Integer gender;
	
	@NotEmpty(message = "Date of Birth must not be empty")
	private Date dateOfBirth;
	
	@NotEmpty(message = "Religion must not be empty")
	private Integer religion;
	
	@NotEmpty(message = "Community must not be empty")
	private Integer community;
	
	@NotEmpty(message = "Mother Tongue must not be empty")
	private Integer motherTongue;
	
	@NotEmpty(message = "Parental Status must not be empty")
	private Integer parentalStatus;
	
	@NotEmpty(message = "Reason For Admission must not be empty")
	private String reasonForAdmission;
	
	@NotEmpty(message = "Education Status must not be empty")
	private Integer educationStatus;
	
	@NotEmpty(message = "Admission Date must not be empty")
	private Date admissionDate;
	
	@NotEmpty(message = "Admitted By must not be empty")
	private Integer admittedBy;
	
	@NotEmpty(message = "Referred By must not be empty")
	private String referredBy;
	
	@NotEmpty(message = "Referred Source must not be empty")
	private String referredSource;
	
	@NotEmpty(message = "Child Status must not be empty")
	private Integer childStatus;

	public Child() {

	}

	public Child(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@Column(name="ChildNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getChildNo() {
		return childNo;
	}

	public void setChildNo(Long childNo) {
		this.childNo = childNo;
	}
	
	@Column(name="ChildID")
	public String getChildStringId() {
		return childStringId;
	}
	
	public void setChildStringId(String childStringId) {
		this.childStringId = childStringId;
	}

	@Column(name = "FirstName", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "Gender")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	@Column(name="CDOB")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name="Religion")
	public Integer getReligion() {
		return religion;
	}

	public void setReligion(Integer religion) {
		this.religion = religion;
	}
	
	@Column(name="Community")
	public Integer getCommunity() {
		return community;
	}

	public void setCommunity(Integer community) {
		this.community = community;
	}
	
	@Column(name="MotherTongue")
	public Integer getMotherTongue() {
		return motherTongue;
	}

	public void setMotherTongue(Integer motherTongue) {
		this.motherTongue = motherTongue;
	}
	
	@Column(name="ParentalStatus")
	public Integer getParentalStatus() {
		return parentalStatus;
	}

	public void setParentalStatus(Integer parentalStatus) {
		this.parentalStatus = parentalStatus;
	}
	
	@Column(name="RFA")
	public String getReasonForAdmission() {
		return reasonForAdmission;
	}

	public void setReasonForAdmission(String reasonForAdmission) {
		this.reasonForAdmission = reasonForAdmission;
	}
	
	@Column(name="EducationStatus")
	public Integer getEducationStatus() {
		return educationStatus;
	}

	public void setEducationStatus(Integer educationStatus) {
		this.educationStatus = educationStatus;
	}
	
	@Column(name="AdmissionDate")
	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	@Column(name="AdmittedBy")
	public Integer getAdmittedBy() {
		return admittedBy;
	}

	public void setAdmittedBy(Integer admittedBy) {
		this.admittedBy = admittedBy;
	}
	
	@Column(name="ReferredBy")
	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}
	
	@Column(name="ReferredSrc")
	public String getReferredSource() {
		return referredSource;
	}

	public void setReferredSource(String referredSource) {
		this.referredSource = referredSource;
	}
	
	@Column(name="ChildStatus")
	public Integer getChildStatus() {
		return childStatus;
	}

	public void setChildStatus(Integer childStatus) {
		this.childStatus = childStatus;
	}
	
	@Column(name="RHNo")
	public Integer getRainbowHomeNumber() {
		return rainbowHomeNumber;
	}

	public void setRainbowHomeNumber(Integer rainbowHomeNumber) {
		this.rainbowHomeNumber = rainbowHomeNumber;
	}
}