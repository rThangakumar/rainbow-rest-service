package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ParentalStatus")
public class ParentalStatus {

	private Integer parentalStatusId;
	private String parentalStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ParentalStatusId")
	public Integer getParentalStatusId() {
		return parentalStatusId;
	}
	public void setParentalStatusId(Integer parentalStatusId) {
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
