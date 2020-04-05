package com.example.restservice.repository;

import java.util.Date;


public interface NotificationCustomRepository  {

	String getEmailIdsByOrg(Integer id);
	String getMobileNumbers(Integer id);
	String getRhTypes(Integer rhNo);
	String getRhCodes(Integer rhNo);
	Integer getChildAge(Date dob);
}