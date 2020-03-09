package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ChildHealth {
	
	@Id
	@GeneratedValue
	private Integer healthNo;
	private Integer childNo;
	private Date healthDate;
	private String height;
	private String weight;
	private Integer generalHealth;
	private String comments;
	private Integer status;
	private Integer healthStatus;

}
