package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HealthChecklistSingle")
public class HealthChecklistSingle {
	
	private Long healthChecklistSingleNo;
	
	private Integer childNo;
	private String hivTestStatus;
	private String tbTestStatus;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HealthChecklistSingleNo")
	public Long getHealthChecklistSingleNo() {
		return healthChecklistSingleNo;
	}
	public void setHealthChecklistSingleNo(Long healthChecklistSingleNo) {
		this.healthChecklistSingleNo = healthChecklistSingleNo;
	}
	
	@Column(name="ChildNo")
	public Integer getChildNo() {
		return childNo;
	}
	public void setChildNo(Integer childNo) {
		this.childNo = childNo;
	}
	
	@Column(name="HivTestStatus")
	public String getHivTestStatus() {
		return hivTestStatus;
	}
	public void setHivTestStatus(String hivTestStatus) {
		this.hivTestStatus = hivTestStatus;
	}
	
	@Column(name="TbTestStatus")
	public String getTbTestStatus() {
		return tbTestStatus;
	}
	public void setTbTestStatus(String tbTestStatus) {
		this.tbTestStatus = tbTestStatus;
	}

}