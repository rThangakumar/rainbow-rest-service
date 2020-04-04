package com.example.restservice.crud;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

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
@Table(name = "ChildMap")
public class ChildMapEnhanced implements Serializable{
	
	private static final long serialVersionUID = -3782354641730928180L;
	
	public ChildMapEnhanced() {
		super();
	}
	
	@Id
	private Integer csmid;
	@NaturalId
	private Long childNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "childStatusID")
	private ChildStatus childStatusID;
	private Date childStatusDate;

}