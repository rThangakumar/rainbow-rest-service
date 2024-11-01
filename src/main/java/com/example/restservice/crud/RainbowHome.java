package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "RainbowHome", schema = "dbo")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
public class RainbowHome {
	
	
	public RainbowHome() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Getter(AccessLevel.NONE)
//	@Setter(AccessLevel.NONE)
	@Column(name = "RHNo")
	public Integer rhNo;

	@Column(name = "RHCode")
	public String rhCode;

	@Column(name = "RHName")
	public String rhName;

	@Column(name = "City")
	public String city;

	@Column(name = "STATUS")
	public Integer status;

	@Column(name = "StateNetworkNo")
	public Short stateNetworkNo;

}