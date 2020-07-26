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
public class ChildEducation {
	
	
	public ChildEducation() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer educationNo;
	public Integer childNo;
	
	public String schoolName;
	public Integer schooltype;
	public Integer studyingclass;
	public Integer medium;
	
	public transient Integer previousClassStudied;
	public transient String dropoutReason;
	
	
	public String address;
	@Column(name="created_by")
	public Integer created_by;
	@Column(name="created_on")
	public Date created_on;
	@Column(name="modified_by")
	public Integer  modified_by;
	public Date modified_on;
	public Integer status;
	public Date date_from;
	public Date date_to;
	public Integer classMapID;
    public Integer	previous_Edu_Details;
    
    public String  stayType;
    public String  bridgeCourse;
    public String  classDetails;
    public String  sponsorship;
    public String  spnsorshipFor;
    
    
    
	public Integer getChildNo() {
		return childNo;
	}
	public void setChildNo(Integer childNo) {
		this.childNo = childNo;
	}
	public Integer getPreviousClassStudied() {
		return previousClassStudied;
	}
	public void setPreviousClassStudied(Integer previousClassStudied) {
		this.previousClassStudied = previousClassStudied;
	}
	public String getDropoutReason() {
		return dropoutReason;
	}
	public void setDropoutReason(String dropoutReason) {
		this.dropoutReason = dropoutReason;
	}
	
	
    

}