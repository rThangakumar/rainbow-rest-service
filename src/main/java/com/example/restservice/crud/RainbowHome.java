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
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
public class RainbowHome {
	
	
	public RainbowHome() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer rhNo;
	public String rhCode;
	
	public String rhName;
	public String city;

	public String getRhCode() {
		return rhCode;
	}

	public void setRhCode(String rhCode) {
		this.rhCode = rhCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRhName() {
		return rhName;
	}

	public void setRhName(String rhName) {
		this.rhName = rhName;
	}
		
	
    

}