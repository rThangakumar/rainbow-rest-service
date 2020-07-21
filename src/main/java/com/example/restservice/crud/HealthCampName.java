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
@NamedNativeQuery(name = "HealthCampName.getUniqueCampName", resultClass = HealthCampName.class, 
   query = "select d.campName as CampName, ROW_NUMBER() over (order by d.campName) as rowNum from \n" + 
   		"  (     \n" + 
   		"select  distinct(a.CampName) as campName from dbo.MultiFormCamps a \n" + 
   		"where  (a.RHNo = :rainbowHomeNumber and a.CampName is not null )\n" + 
   		") as d"

)
public class HealthCampName {

	@Id
	private Integer rowNum;

	private String campName;
	

}
