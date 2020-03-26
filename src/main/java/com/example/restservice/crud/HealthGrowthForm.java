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
public class HealthGrowthForm {
	
	public HealthGrowthForm() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer healthGrowthFormNo;
	private Long childNo;
	private Date assessmentDate;
	private Integer height;
	private Integer weight;
	private String generalHealth;
	private String comments;
	private String healthStatus;
	
	public void setHealthGrowthFormNo(Integer healthGrowthFormNo) {
		healthGrowthFormNo = healthGrowthFormNo;
	}
	
}