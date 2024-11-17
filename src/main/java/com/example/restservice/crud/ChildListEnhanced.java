package com.example.restservice.crud;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ChildBasic")
@NamedNativeQueries({
		@NamedNativeQuery(name = "ChildListEnhanced.getChildEnhancedList", resultClass = ChildListEnhanced.class, query = "select cb.childno, cb.ChildID , cb.RHNo, cb.EducationStatus , cb.FirstName,  cm_filter.childStatusDate,cs.ChildStatus "
				+ ", cb.LastName, cs.ChildStatusID, cb.Gender,cb.CDOB,cb.AdmissionDate,cb.Picture "
				+ "from childbasic cb\n" + "-- join for status update\n" + " LEFT join \n"
				+ "(Select CSM.ChildNo,CSM.Reason, CSM.childStatusDate as childStatusDate from ChildMap CSM join (Select CSM.ChildNo, MAX(CSM.CSMID) as CSMID from ChildMap CSM Group By CSM.ChildNo) as E on E.CSMID = CSM.CSMID) as cm_filter on cm_filter.ChildNo = cb.ChildNo\n"
				+ "-- join status value\n" + "JOIN ChildStatus CS ON CS.ChildStatusID = CB.ChildStatus \n"
//				+ "-- profile status query\n" + "\n" + " LEFT JOIN \n" + "(select \n" + "case \n"
//				+ "    when (DATEDIFF(DAYOFYEAR , pd.MODIFIED_ON, SYSDATETIME()) >=365) THEN 'Y'\n"
//				+ "    when (pd.MODIFIED_ON IS NULL) THEN 'Y'\n" + "    else 'N' \n"
//				+ "end as ProfileStatusFlag, pd.ChildNo as childno, DATEDIFF(DAYOFYEAR , pd.MODIFIED_ON, SYSDATETIME()) as datedifference from ProfileDescription pd\n"
//				+ "JOIN\n"
//				+ "(select MAX(ProfileDescriptionNo) as profileDescNo from ProfileDescription group by ChildNo)as PE on PE.profileDescNo = pd.ProfileDescriptionNo)as pde on pde.childno = cb.childno\n"
				+ " where cb.RHNo = :rainbowHomeNumber"

		),
		@NamedNativeQuery(name = "ChildListEnhanced.updatePicture", resultClass = ChildListEnhanced.class, query = "UPDATE childbasic SET picture = :picture WHERE childNo = :childNo")

})
public class ChildListEnhanced {

	private Long childNo;
	private Integer RHNo;
	private String childID;
	private Integer educationStatus;
	private String firstName;
	private Date childStatusDate;
	private String childStatus;
//	private String profileStatusFlag;
	private String lastName;
	private Integer childStatusId;
	private Integer gender;
	private Date dateOfBirth;
	private Date admissionDate;
	private String picture;

	@Id
	@Column(name = "ChildNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getChildNo() {
		return childNo;
	}

	@Column(name = "CDOB")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

}
