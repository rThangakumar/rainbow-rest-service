package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildEducation {
	
	
	public ChildEducation() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer educationNo;
	public Integer childNo;
	
	public String schoolName;
	public Integer schooltype;
	public Integer studyingclass;
	public Integer medium;
	
	
	public String address;
	public Integer created_by;
	public Date created_on;
	
	public Integer  modified_by;
	public Date modified_on;
	public Integer status;
	public Date date_from;
	public Date date_to;
	public Integer classMapID;
    public Integer	previous_Edu_Details;
	

}