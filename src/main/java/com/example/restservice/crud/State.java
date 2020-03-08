package com.example.restservice.crud;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class State {
	
	@Id
	@GeneratedValue
	public int stateID;
	public String state;
    
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "countryID")
	public Country country;

}