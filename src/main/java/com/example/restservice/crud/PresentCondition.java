package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PresentCondition {
	
	@Id
	@GeneratedValue
	public int preconNo;
	public String precon;
	public int getPreconNo() {
		return preconNo;
	}
	public void setPreconNo(int preconNo) {
		this.preconNo = preconNo;
	}
	public String getPrecon() {
		return precon;
	}
	public void setPrecon(String precon) {
		this.precon = precon;
	}
	
	

}