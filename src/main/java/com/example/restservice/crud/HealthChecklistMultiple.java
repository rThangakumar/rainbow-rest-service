package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class HealthChecklistMultiple {
	
	@Id
	@GeneratedValue
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Long healthChecklistMultipleNo;
	private Integer childNo;
	private Boolean deworming;
	private Date dewormingDate;
	private String campCheckups;
	private Boolean gynecology;
	private Date gynecologyDate;

}