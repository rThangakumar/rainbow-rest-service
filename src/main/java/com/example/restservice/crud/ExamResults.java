package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ExamResults {
	
	
	public ExamResults() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	public Integer resultId;
	public Integer childNo;
	public Integer examId;
    public String appeared;
    public String result;
    public float percentage;
    public String examDescription;
    
    @Column(name="class")
    public Integer studyingClass;
}