package com.example.restservice.crud;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ChildBasic")
public class Child {

	//Name, DOB, Mother Tongue, Admission date, Religion, Home code
	//firstNameAndlastNameAnddateOfBirthAndmotherTongueAndadmissionDateAndReligionAndrainbowHomeNumber
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
	
	private String picture;
	
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
	
	private Long aadharNumber;
	private String abuseOnStreet;
	private String noOfTimesLeavingHome;
	

	
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
	
	@Column(name="IdentificationMark1")
	public String getIdentificationMark1() {
		return identificationMark1;
	}

	public void setIdentificationMark1(String identificationMark1) {
		this.identificationMark1 = identificationMark1;
	}
	
	@Column(name="IdentificationMark2")
	public String getIdentificationMark2() {
		return identificationMark2;
	}

	public void setIdentificationMark2(String identificationMark2) {
		this.identificationMark2 = identificationMark2;
	}
	
	@Column(name="StayReason")
	public Integer getStayReason() {
		return stayReason;
	}

	public void setStayReason(Integer stayReason) {
		this.stayReason = stayReason;
	}
	
	@Column(name="Occupation")
	public Integer getOccupation() {
		return occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}
	
	@Column(name="DifferentlyAbledGroup")
	public Integer getDifferentlyAbledGroup() {
		return differentlyAbledGroup;
	}

	public void setDifferentlyAbledGroup(Integer differentlyAbledGroup) {
		this.differentlyAbledGroup = differentlyAbledGroup;
	}

	@Column(name="DropoutReason")
	public String getDropoutReason() {
		return dropoutReason;
	}

	public void setDropoutReason(String dropoutReason) {
		this.dropoutReason = dropoutReason;
	}
	
	@Column(name="Duration")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Column(name="OrganisationName")
	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	
	@Column(name="CWCRefNo")
	public String getcWCRefNo() {
		return cWCRefNo;
	}

	public void setcWCRefNo(String cWCRefNo) {
		this.cWCRefNo = cWCRefNo;
	}
	
	@Column(name="PreviousClassStudied")
	public Integer getPreviousClassStudied() {
		return previousClassStudied;
	}

	public void setPreviousClassStudied(Integer previousClassStudied) {
		this.previousClassStudied = previousClassStudied;
	}
	
	@Column(name="BloodGroup")
	public Integer getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAbuseOnStreet() {
		return abuseOnStreet;
	}

	public void setAbuseOnStreet(String abuseOnStreet) {
		this.abuseOnStreet = abuseOnStreet;
	}

	public String getNoOfTimesLeavingHome() {
		return noOfTimesLeavingHome;
	}

	public void setNoOfTimesLeavingHome(String noOfTimesLeavingHome) {
		this.noOfTimesLeavingHome = noOfTimesLeavingHome;
	}
	
	
	
}