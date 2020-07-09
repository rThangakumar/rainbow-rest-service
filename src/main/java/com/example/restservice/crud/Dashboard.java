package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ChildBasic")
@NamedNativeQuery(name = "Dashboard.getDashboardDetails", 
resultClass = Dashboard.class, 
query ="select count(*) as total, E.ChildStatus as statusValue from \n" + 
		" (select   cs.ChildStatus from dbo.childbasic  CB\n" + 
		" JOIN ChildStatus CS ON CS.ChildStatusID = CB.ChildStatus\n" + 
		"  where RHNo = :RBNo ) as E  \n" + 
		"  group by E.ChildStatus;")
public class Dashboard {
	
	private String total;
	
	@Id
	private String statusValue;

}
