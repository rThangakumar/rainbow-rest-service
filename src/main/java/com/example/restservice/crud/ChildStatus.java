package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ChildStatus")
public class ChildStatus {
	
	private Integer childStatusId;
	private String childStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ChildStatusID")
	public Integer getChildStatusId() {
		return childStatusId;
	}
	public void setChildStatusId(Integer childStatusId) {
		this.childStatusId = childStatusId;
	}
	
	@Column(name="ChildStatus")
	public String getChildStatus() {
		return childStatus;
	}
	public void setChildStatus(String childStatus) {
		this.childStatus = childStatus;
	}
	
}