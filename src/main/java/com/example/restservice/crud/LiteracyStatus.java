package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Table(name = "LiteracyStatus")
public class LiteracyStatus {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Description")
	private String description;
}
