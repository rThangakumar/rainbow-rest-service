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

	private long childNo;
	private String childStringId;
	private String firstName;
	private String lastName;
	private int gender;
	private Date dob;

	public Child() {

	}

	public Child(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@Column(name="ChildNo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getChildNo() {
		return childNo;
	}

	public void setChildNo(long childNo) {
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
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Column(name="CDOB")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
