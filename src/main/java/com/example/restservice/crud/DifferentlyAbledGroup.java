package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DifferentlyAbledGroup")
public class DifferentlyAbledGroup {
	
	private Integer differentlyAbledGroupId;
	private String differentlyAbledGroup;
	
	@Id
	@Column(name="DifferentlyAbledGroupID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDifferentlyAbledGroupId() {
		return differentlyAbledGroupId;
	}
	public void setDifferentlyAbledGroupId(Integer differentlyAbledGroupId) {
		this.differentlyAbledGroupId = differentlyAbledGroupId;
	}
	
	@Column(name="DifferentlyAbledGroup")
	public String getDifferentlyAbledGroup() {
		return differentlyAbledGroup;
	}
	public void setDifferentlyAbledGroup(String differentlyAbledGroup) {
		this.differentlyAbledGroup = differentlyAbledGroup;
	}

}
