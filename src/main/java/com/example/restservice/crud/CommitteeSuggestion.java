package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CommitteeSuggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long committeeSuggestionNo;
	private Long childNo;
	private Integer staffNo;
	private Date committeeSuggestionDate;
	private String committeeSuggestionText;
	public void setCommitteeSuggestionNo(Long committeeSuggestionNo) {
		this.committeeSuggestionNo = committeeSuggestionNo;
	}
	

}