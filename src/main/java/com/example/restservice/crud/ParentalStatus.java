package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ParentalStatus")
public class ParentalStatus {

	private int parentalStatusId;
	private String parentalStatus;
	
	@Column(name="ParentalStatusId")
	public int getParentalStatusId() {
		return parentalStatusId;
	}
	public void setParentalStatusId(int parentalStatusId) {
		this.parentalStatusId = parentalStatusId;
	}
	
	@Column(name="ParentalStatus")
	public String getParentalStatus() {
		return parentalStatus;
	}
	public void setParentalStatus(String parentalStatus) {
		this.parentalStatus = parentalStatus;
	}
	
	
	
}
