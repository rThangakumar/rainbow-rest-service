package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
public class ChildExitCredentials {
	
	public ChildExitCredentials() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long childNo;
	private String password;
	private String email;
	private String phoneNo;
	private String futureGroup;
	
	public Long getChildNo() {
		return childNo;
	}
	public void setChildNo(Long childNo) {
		this.childNo = childNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFutureGroup() {
		return futureGroup;
	}
	public void setFutureGroup(String futureGroup) {
		this.futureGroup = futureGroup;
	}
	
	
	
}