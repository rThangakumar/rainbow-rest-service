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
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ChildFamily {
	
	
	public ChildFamily() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer familyNo;
	public Integer childNo;
	public String name;
	public Integer relation;
	public transient String relationType;
	public String age;
	public Integer occupation;
	public transient String occupationType;
	public Integer presentcondition;
	public transient String presentconditionType;
	public String income;
	public String remarks;
	public Integer deletestatus;
	
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}
	public Integer getRelation() {
		return relation;
	}
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	public Integer getOccupation() {
		return occupation;
	}
	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}
	public Integer getPresentcondition() {
		return presentcondition;
	}
	public void setPresentcondition(Integer presentcondition) {
		this.presentcondition = presentcondition;
	}
	public String getPresentconditionType() {
		return presentconditionType;
	}
	public void setPresentconditionType(String presentconditionType) {
		this.presentconditionType = presentconditionType;
	}
	
	

}