package com.example.restservice.crud;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "ChildAddress.getEmailIds", procedureName = "sp_Select_EmailIds",
parameters  = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "OrgId", type = Integer.class)}),
@NamedStoredProcedureQuery(name = "ChildAddress.getMobileNos", procedureName = "sp_Select_MobileNos",
parameters  = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "OrgId", type = Integer.class)}),
@NamedStoredProcedureQuery(name = "ChildAddress.getRhTypes", procedureName = "sp_fetch_RHtypes",
parameters  = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "RHNo", type = Integer.class)}),
@NamedStoredProcedureQuery(name = "ChildAddress.getRhCodes", procedureName = "sp_fetch_RHCodes",
parameters  = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "RHNo", type = Integer.class)}),
@NamedStoredProcedureQuery(name = "ChildAddress.getAge", procedureName = "sp_findage",
parameters  = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "CDOB", type = Integer.class)})
})
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
//@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildAddress {
	//
	
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