package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProfileDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long profileDescriptionNo;
	public Long childNo;
	public String description;
	public Date modified_ON;
	public void setProfileDescriptionNo(Long profileDescriptionNo) {
		this.profileDescriptionNo = profileDescriptionNo;
	}

}