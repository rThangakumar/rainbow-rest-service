package com.example.restservice.crud;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class CommitteeSuggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CommitteeSuggestionNo")
	private Long committeeSuggestionNo;
	
	@Column(name="ChildNo")
	private Long childNo;
	
	@Column(name="StaffNo")
	private Integer staffNo;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "CommitteeSuggestionNo",
        referencedColumnName = "CommitteeSuggestionNo"
    )
	private List<CommitteeSuggestion_staff> staffNumber;
    
	@Column(name="CommitteeSuggestionDate")
	private Date committeeSuggestionDate;
	
	@Column(name="CommitteeSuggestionText")
	private String committeeSuggestionText;
	
	public void setCommitteeSuggestionNo(Long committeeSuggestionNo) {
		this.committeeSuggestionNo = committeeSuggestionNo;
	}

}