package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StayReason")
public class StayReason {
	
	private Integer stayReasonId;
	private String stayReason;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StayReasonId")
	public Integer getStayReasonId() {
		return stayReasonId;
	}
	public void setStayReasonId(Integer stayReasonId) {
		this.stayReasonId = stayReasonId;
	}
	
	@Column(name="StayReason")
	public String getStayReason() {
		return stayReason;
	}
	public void setStayReason(String stayReason) {
		this.stayReason = stayReason;
	}
	
}