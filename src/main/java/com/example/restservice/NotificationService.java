package com.example.restservice;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.RainbowHome;
import com.example.restservice.model.EmailData;
import com.example.restservice.model.SMSDetails;
import com.example.restservice.repository.NotificationCustomRepository;
import com.example.restservice.repository.RainbowHomeRepository;
import com.example.restservice.utils.EmailService;
import com.example.restservice.utils.SMSService;

@Component
public class NotificationService {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	SMSService smsService;
	
	@Autowired
	NotificationCustomRepository notificationRepo;
	
	@Autowired
	RainbowHomeRepository rainbowRepository;
	
	private String fromAddress;
	
	
	
	public boolean sendAddChildNotification(Child child, Integer orgId) {
		int id = orgId;// replace this with the logged in user ord id
		//String message = "";
		
		String toEmailIds = notificationRepo.getEmailIdsByOrg(id);
		String rhTypes = notificationRepo.getRhTypes(id);
		String rhCodes = notificationRepo.getRhCodes(id);
		String mobildNos = notificationRepo.getMobileNumbers(id);
		Optional<RainbowHome> rhHomeList = rainbowRepository.findById(Integer.valueOf(id));
		String city = null;
		String name = null;
		if(rhHomeList.isPresent()) {
			city = rhHomeList.get().getCity();
			name = rhHomeList.get().getRhName();
		}
		int age = calculateAge(child.getDateOfBirth());
		if( (child.getChildNo() == 0 && rhTypes == "1")) {
			if (toEmailIds == "")
            {
				toEmailIds = "raju.rfi@rainbowhome.in,babu.rfi@rainbowhome.in";
				//Msg.Bcc.Add("raju.rfi@rainbowhome.in,babu.rfi@rainbowhome.in");
				
            }
		}
		String childName = child.getFirstName()+" " +child.getLastName();
		String message = "Hi Team" + System.lineSeparator()+ System.lineSeparator()
		+"Child Name " + childName + 
		" " + age + " Years old" + " admitted" + " on Date" + child.getAdmissionDate() + 
		" in Code  based on " + System.lineSeparator() 
		+ "level "+rhCodes + System.lineSeparator() +
		"Type RH City "+city+ " for " + child.getReasonForAdmission()+"." + 
		System.lineSeparator() +
		System.lineSeparator() + 
		"Hearty Welcome "+childName + System.lineSeparator() + 
		"Thank you" 
		+System.lineSeparator() + 
				 "This is test message pls ignore";
		
		EmailData emailParams = new EmailData();
		emailParams.setFromAddress(fromAddress);
		emailParams.setSubject("Test");
		emailParams.setMessage(message);
		emailParams.setSubject(child.getFirstName() + " " + child.getLastName() + "(" + age + ")yrs admitted  in " + rhCodes);
		emailParams.setToAddress(toEmailIds);
		emailParams.setBccAdress("Srinivas.uppu@gmail.com, raju.rfi@rainbowhome.in, babu.rfi@rainbowhome.in");
		
		try {
			emailService.sendHtmlMail(emailParams);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SMSDetails smsDetails = new SMSDetails();
		smsDetails.setMessage(message);
		smsDetails.setSender("RFIROR");
		smsDetails.setMobileNo(mobildNos+"9000988856");
		smsService.sendSms(smsDetails);
		return true;
	}
	
	public boolean sendUpdateChildNotification(Child child) {
		int id = child.getRainbowHomeNumber();// replace this with the logged in user ord id
		//String message = "";
		
		String toEmailIds = notificationRepo.getEmailIdsByOrg(id);
		String rhTypes = notificationRepo.getRhTypes(id);
		String rhCodes = notificationRepo.getRhCodes(id);
		String mobildNos = notificationRepo.getMobileNumbers(id);
		Optional<RainbowHome> rhHomeList = rainbowRepository.findById(Integer.valueOf(id));
		String city = null;
		String name = null;
		if(rhHomeList.isPresent()) {
			city = rhHomeList.get().getCity();
			name = rhHomeList.get().getRhName();
		}
		int age = calculateAge(child.getDateOfBirth());
		if( (child.getChildNo() == 0 && rhTypes == "1")) {
			if (toEmailIds == "")
            {
				toEmailIds = "raju.rfi@rainbowhome.in,babu.rfi@rainbowhome.in";
				//Msg.Bcc.Add("raju.rfi@rainbowhome.in,babu.rfi@rainbowhome.in");
				
            }
		}
		String childName = child.getFirstName()+" " +child.getLastName();
		String message = "Hi Team" + System.lineSeparator()+ System.lineSeparator()
		+"Child Name " + childName + 
		" " + age + " Years old" + " admitted" + " on Date" + child.getAdmissionDate() + 
		" in Code  based on " + System.lineSeparator() 
		+ "level "+rhCodes + System.lineSeparator() +
		"Type RH City "+city+ " for reason child wants to be with Parents/Grand parents/Guardian though the family condition not improved." + 
		System.lineSeparator() +
		System.lineSeparator() + 
		 
		"Thank you" 
		+System.lineSeparator() + 
				 "This is test message pls ignore";
		
		EmailData emailParams = new EmailData();
		emailParams.setFromAddress(fromAddress);
		emailParams.setSubject("Test");
		emailParams.setMessage(message);
		emailParams.setSubject(child.getFirstName() + " " + child.getLastName() + "(" + age + ")yrs admitted  in " + rhCodes);
		emailParams.setToAddress(toEmailIds);
		emailParams.setBccAdress("Srinivas.uppu@gmail.com, raju.rfi@rainbowhome.in, babu.rfi@rainbowhome.in");
		
		try {
			emailService.sendHtmlMail(emailParams);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SMSDetails smsDetails = new SMSDetails();
		smsDetails.setMessage(message);
		smsDetails.setSender("RFIROR");
		smsDetails.setMobileNo(mobildNos+"9000988856");
		smsService.sendSms(smsDetails);
		return true;
		
	}
	
	private int calculateAge(Date dob) {
		LocalDate today = LocalDate.now();   
		LocalDate birthday = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period p = Period.between(birthday, today);
		return p.getYears();
	}
	

}
