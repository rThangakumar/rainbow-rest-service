package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class Staff {
	
	private int staffNo;
	private String firstName;
	private String lastName;
	private int staffStatus;
	private String staffId;
	
	@Column=("StaffNo")
	public int getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}
	
	@Column=("FirstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column=("LastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column=("StaffStatus")
	public int getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(int staffStatus) {
		this.staffStatus = staffStatus;
	}
	
	@Column=("StaffID")
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	

}
