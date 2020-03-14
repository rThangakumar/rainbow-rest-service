package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class ChildLeavingReason {
	
	public ChildLeavingReason() {
		super();
	}
	
	@Id
	private Long leavingReasonId;
	private String leavingReason;
	private Integer category;
	private Integer status;
	private Integer orderno;

}