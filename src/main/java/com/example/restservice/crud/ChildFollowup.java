package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class ChildFollowup {
	
	public ChildFollowup() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childFollowupNo;
	private Long childNo;
	private Integer staffNo;
	private Date followupDate;
	private String comments;
	public Integer getChildFollowupNo() {
		return childFollowupNo;
	}
	public void setChildFollowupNo(Integer childFollowupNo) {
		this.childFollowupNo = childFollowupNo;
	}
	
}