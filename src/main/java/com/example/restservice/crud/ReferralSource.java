package com.example.restservice.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ReferralSource")
public class ReferralSource {
	
	private int referralSourceId;
	private String referralSource;
	
	@Column(name="RefSrcNo")
	public int getReferralSourceId() {
		return referralSourceId;
	}
	public void setReferralSourceId(int referralSourceId) {
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
