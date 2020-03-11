package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="HealthChecklistMultiple")
public class HealthChecklistMultiple {
	
	private Long healthChecklistMultipleNo;
	private Integer childNo;
	private Boolean deworming;
	private Date dewormingDate;
	private String campCheckups;
	private Boolean gynecology;
	private Date gynecologyDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HealthChecklistMultipleNo")
	public Long getHealthChecklistMultipleNo() {
		return healthChecklistMultipleNo;
	}
	public void setHealthChecklistMultipleNo(Long healthChecklistMultipleNo) {
		this.healthChecklistMultipleNo = healthChecklistMultipleNo;
	}
	
	@Column(name="ChildNo")
	public Integer getChildNo() {
		return childNo;
	}
	public void setChildNo(Integer childNo) {
		this.childNo = childNo;
	}
	
	@Column(name="Deworming")
	public Boolean getDeworming() {
		return deworming;
	}
	public void setDeworming(Boolean deworming) {
		this.deworming = deworming;
	}
	
	@Column(name="DewormingDate")
	public Date getDewormingDate() {
		return dewormingDate;
	}
	public void setDewormingDate(Date dewormingDate) {
		this.dewormingDate = dewormingDate;
	}
	
	@Column(name="CampCheckups")
	public String getCampCheckups() {
		return campCheckups;
	}
	public void setCampCheckups(String campCheckups) {
		this.campCheckups = campCheckups;
	}
	
	@Column(name="Gynecology")
	public Boolean getGynecology() {
		return gynecology;
	}
	public void setGynecology(Boolean gynecology) {
		this.gynecology = gynecology;
	}
	
	@Column(name="GynecologyDate")
	public Date getGynecologyDate() {
		return gynecologyDate;
	}
	public void setGynecologyDate(Date gynecologyDate) {
		this.gynecologyDate = gynecologyDate;
	}

}