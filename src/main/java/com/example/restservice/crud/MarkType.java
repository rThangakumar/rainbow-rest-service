package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MarkType")
public class MarkType {
	
	private Integer markTypeId;
	private String markType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MarkTypeID")
	public Integer getMarkTypeId() {
		return markTypeId;
	}
	public void setMarkTypeId(Integer markTypeId) {
		this.markTypeId = markTypeId;
	}
	
	@Column(name="MarkType")
	public String getMarkType() {
		return markType;
	}
	public void setMarkType(String markType) {
		this.markType = markType;
	}
	
}