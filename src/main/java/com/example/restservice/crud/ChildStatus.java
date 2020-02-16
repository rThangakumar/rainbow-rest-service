package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ChildStatus")
public class ChildStatus {
	
	private int childStatusId;
	private int childStatus;
	
	@Column(name="ChildStatusID")
	public int getChildStatusId() {
		return childStatusId;
	}
	public void setChildStatusId(int childStatusId) {
		this.childStatusId = childStatusId;
	}
	
	@Column(name="ChildStatus")
	public int getChildStatus() {
		return childStatus;
	}
	public void setChildStatus(int childStatus) {
		this.childStatus = childStatus;
	}
	
}
