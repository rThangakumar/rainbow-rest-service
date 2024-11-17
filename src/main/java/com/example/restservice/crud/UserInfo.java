package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
public class UserInfo {
	
	public UserInfo() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNo;

	@NotNull
	private String userName;

	@NotNull
	private String password;
//	private String encryptedPassword;

	private Integer orgId;

	private Integer orgLevelNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgId", referencedColumnName = "RHNo", insertable = false, updatable = false)
    private RainbowHome rainbowHome;
	

}