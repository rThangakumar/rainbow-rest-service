package com.example.restservice.crud;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
public class ChildMap implements Serializable{
	
	private static final long serialVersionUID = -3782354641730928180L;
	
	public ChildMap() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer csmid;
	private Long childNo;
	private Integer childStatusID;
	private Date childStatusDate;
	private Integer leavingReasonId;
	private String reason;
	private Integer childLeftPlaceId;
	private Integer actionTakenId;
	private String childStayPlace;
	private Integer followedBy;
	private Integer approvedBy;
	
}