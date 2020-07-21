package com.example.restservice.crud;

import java.util.Date;

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
@Table(name="MultiFormCamps")
public class HealthMultiFormCamps {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Long childNo;
	private Long RHNo;
	private String campName;
	private String hospitalName;
	private Date campDate;
	private  String recommendations;
}
