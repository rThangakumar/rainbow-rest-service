package com.example.restservice.crud;

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
public class ClosedChildActionList {
	
	public ClosedChildActionList() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer actionId;
	private String actionTaken;

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
}
