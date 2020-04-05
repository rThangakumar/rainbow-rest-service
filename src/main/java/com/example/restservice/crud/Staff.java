package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class Staff {
	
	private Integer staffNo;
	private String firstName;
	private String lastName;
	private Integer staffStatus;
	private String staffId;
	private Integer orgID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffNo")
	public Integer getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(Integer staffNo) {
		this.staffNo = staffNo;
	}
	
	@Column(name="FirstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="StaffStatus")
	public Integer getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(Integer staffStatus) {
		this.staffStatus = staffStatus;
	}
	
	@Column(name="StaffID")
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	@Column(name="OrgID")
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	
}
