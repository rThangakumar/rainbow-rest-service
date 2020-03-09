package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SchoolType {

	@Id
	@GeneratedValue
	public int schoolTypeID;
	public String schoolType;

}