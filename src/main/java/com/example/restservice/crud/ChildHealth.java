package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildHealth {
	
	public ChildHealth() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long healthNo;
	private Integer childNo;
	private Date healthDate;
	private String height;
	private String weight;
	private Integer generalHealth;
	private String comments;
	private Integer status;
	private Integer healthStatus;
	public void setHealthNo(Long healthNo) {
		this.healthNo = healthNo;
		
	}
	
}
