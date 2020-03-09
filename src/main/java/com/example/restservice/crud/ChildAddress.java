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
public class ChildAddress {
	
	
	public ChildAddress() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer addressNo;
	public Integer addressID;
	public String presentAddress1;
	public String presentAddress2;
	public Integer presentCountry;
	public Integer presentStateRH;
	public Integer presentDistrict;
	public Integer PresentPincode;
	public String PhoneNo;
	public String mobileNo;
	public String permtAddress1;
	public String permtAddress2;
	public Integer permtCountry;
	public Integer permtStateRH;
	public Integer permtDistrict;
	public Integer permtPincode;
	public String presentCity;
		

}