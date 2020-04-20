package com.example.restservice.crud;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CommitteeSuggestion_staff {

	public CommitteeSuggestion_staff() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="StaffSuggestionNo")
	private Integer StaffSuggestionNo;
	
	@Column(name="StaffNo")
	private Integer StaffNo;
	
	@ManyToOne
    @JoinColumn(name = "CommitteeSuggestionNo")
	private CommitteeSuggestion parent;
	
	
	

}
