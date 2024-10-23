package com.example.restservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponseDTO {
	
	private Boolean authStatus;
	private Integer orgId;
	private String homeCode;
	private String comments;
	private Integer userId;

}