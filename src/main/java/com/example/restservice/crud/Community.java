package com.example.restservice.crud;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Community")
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int communityId;
	private String community;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CommunityId")
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	
	@Column(name="Community")
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	
	

}
