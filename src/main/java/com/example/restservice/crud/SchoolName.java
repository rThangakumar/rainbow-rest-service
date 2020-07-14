package com.example.restservice.crud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Table(name = "ChildEducation")
@NamedNativeQuery(name = "SchoolName.getUniqueSchoolName", resultClass = SchoolName.class, query = "select d.schoolname , ROW_NUMBER() over (order by d.schoolname) as rownum from (\n"
		+ "   select distinct(e.schoolname) as schoolname from (\n"
		+ "   select  a.schoolname, b.RHNo  from dbo.childeducation a\n"
		+ " join dbo.childbasic b on a.childno = b.childno\n" + " where  b.RHNo = :rainbowHomeNumber \n" + " ) as e\n"
		+ ") as d"

)
public class SchoolName {

	@Id
	private Integer rowNum;

	private String schoolName;
	

}
