package com.example.restservice.crud;

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
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
public class HealthChecklistSingle {
	
	@Id
	@GeneratedValue
	private Long healthChecklistSingleNo;
	private Integer childNo;
	private String hivTestStatus;
	private String tbTestStatus;

}