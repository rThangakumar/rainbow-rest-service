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
	
	private int childStatusId;
	private int childStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
