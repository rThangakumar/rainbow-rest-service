package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildMap {
	
	public ChildMap() {
		super();
	}
	
	@Id
	private Integer csmid;
	private Long childNo;
	private Integer childStatusID;
	private Date childStatusDate;

}