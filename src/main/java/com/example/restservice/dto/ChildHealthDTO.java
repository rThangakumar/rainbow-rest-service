package com.example.restservice.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChildHealthDTO {
	
	private Integer healthNo;
	private Long childNo;
	private Date healthDate;
	private String height;
	private String weight;
	private Integer generalHealth;
	private String comments;
	private Integer status;
	private Integer healthStatus;
	private Integer bloodGroup;

}