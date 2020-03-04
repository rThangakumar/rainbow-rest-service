package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ReferralSource")
public class ReferralSource {
	
	private Integer referralSourceId;
	private String referralSource;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RefSrcNo")
	public Integer getReferralSourceId() {
		return referralSourceId;
	}
	public void setReferralSourceId(Integer referralSourceId) {
		this.referralSourceId = referralSourceId;
	}
	
	@Column(name="RefSrc")
	public String getReferralSource() {
		return referralSource;
	}
	public void setReferralSource(String referralSource) {
		this.referralSource = referralSource;
	}

}
