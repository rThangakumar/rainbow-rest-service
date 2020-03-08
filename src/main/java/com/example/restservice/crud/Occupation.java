package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Occupation {
	
	@Id
	@GeneratedValue
	public int occupationNo;
	public String occupation;

}