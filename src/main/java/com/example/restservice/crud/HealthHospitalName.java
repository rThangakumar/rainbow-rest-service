package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Table(name = "MultiFormCamps")
@NamedNativeQuery(name = "HealthHospitalName.getUniqueHospitalName", resultClass = HealthHospitalName.class, 
    query = " select d.HospitalName as HospitalName, ROW_NUMBER() over (order by d.HospitalName) as rowNum from \n" + 
    		"  (     \n" + 
    		"select  distinct(a.HospitalName) as HospitalName from dbo.MultiFormCamps a \n" + 
    		"where  (a.RHNo = :rainbowHomeNumber and a.HospitalName is not null )\n" + 
    		") as d"

)
public class HealthHospitalName {

	@Id
	private Integer rowNum;

	private String hospitalName;
	

}
