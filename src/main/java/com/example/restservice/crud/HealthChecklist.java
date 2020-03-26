package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Table(name="HealthChecklist")
public class HealthChecklist {
	
	private Integer healthChecklistNo;
	private Long childNo;
	private Boolean hivTestDone;
	private Boolean hivTestResult;
	private Boolean tbTestDone;
	private Boolean tbTestResult;
	private Boolean dewormingDone;
	private Date dewormingDate;
	private String campCheckupNotes;
	private Boolean gynecologyCheckupDone;
	private Date gynecologyCheckupDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HealthChecklistNo")
	public Integer getHealthChecklistNo() {
		return healthChecklistNo;
	}
	public void setHealthChecklistNo(Integer healthChecklistNo) {
		this.healthChecklistNo = healthChecklistNo;
	}

}