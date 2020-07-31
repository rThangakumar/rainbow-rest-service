package com.example.restservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.restservice.controller.ChildStatusController;
import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildExitCredentials;
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
	
	Logger LOG = LoggerFactory.getLogger(NotificationService.class);
	
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
		rhCodes = getRhCode(child, rhCodes);
		DateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd, yyyy");
	    String admissionDateStr = simpleDateFormat.format(child.getAdmissionDate());

		String message = "Hi Team <br/>" + System.lineSeparator()+ System.lineSeparator()
		+"Child Name " + childName + 
		"" + age + " Years old" + " admitted" + " on " + admissionDateStr + 
		" in "+rhCodes + "."+
		"<br/><br/>"+
		 
		"Hearty Welcome "+childName + "<br/>" + 
		"Thank you "+"<br/>"+
		"Rainbow Homes "+"<br/>" +
		"Program Rainbow Foundation India";
		
		EmailData emailParams = new EmailData();
		emailParams.setFromAddress(fromAddress);
		emailParams.setSubject("Test");
		emailParams.setMessage(message);
		emailParams.setSubject(childName + " (" + age + ")yrs admitted  in " + rhCodes);
		emailParams.setToAddress(toEmailIds);
		emailParams.setBccAdress("raju.rfi@rainbowhome.in, babu.rfi@rainbowhome.in");
		
		try {
			emailService.sendHtmlMail(emailParams);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SMSDetails smsDetails = new SMSDetails();
		smsDetails.setMessage(message);
		smsDetails.setSender("RFIROR");
		smsDetails.setMobileNo(mobildNos);
		smsService.sendSms(smsDetails);
		return true;
	}

	private String getRhCode(Child child, String rhCodes) {
		//1- Girl
		//2 -> Boy
		if(1 == child.getGender()) {
			rhCodes =  rhCodes.replaceFirst("SG ", "RH ");
		} else if(2 == child.getGender()) {
			rhCodes =  rhCodes.replaceFirst("RH ", "SG ");
		}
		return rhCodes;
	}
	
	public boolean sendUpdateChildExitingNotification(Child child) {
		int id = child.getRainbowHomeNumber();
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
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String today = DateFor.format(date);
		String message = "Hi Team, <br/>" + 
		childName +" " + age + " Years old" + " Exited" + " on " + today + 
		" in "+rhCodes + " for Parents are able to take care of child."+"<br/>"+
		 
		"<br/>" +	 
		"Thank you "+"<br/>"+
		"Rainbow Homes "+"<br/>" +
		"Program Rainbow Foundation India"; 
		
		EmailData emailParams = new EmailData();
		emailParams.setFromAddress(fromAddress);
		emailParams.setMessage(message);
		//Rajni Priyanka (16) yrs Exit in NDB RH, DELHI
		emailParams.setSubject(child.getFirstName() + " " + child.getLastName() + " (" + age + ") yrs Exit in " + rhCodes);
		emailParams.setToAddress(toEmailIds);
		emailParams.setBccAdress("raju.rfi@rainbowhome.in, babu.rfi@rainbowhome.in");
		
		try {
			emailService.sendHtmlMail(emailParams);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SMSDetails smsDetails = new SMSDetails();
		smsDetails.setMessage(message);
		smsDetails.setSender("RFIROR");
		smsDetails.setMobileNo(mobildNos);
		smsService.sendSms(smsDetails);
		return true;
		
	}
	
	private int calculateAge(Date dob) {
		LocalDate today = LocalDate.now();   
		LocalDate birthday = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period p = Period.between(birthday, today);
		return p.getYears();
	}
	
	public boolean sendExitCredentials(Child child, ChildExitCredentials cred) {

		
		String childName = child.getFirstName()+" " +child.getLastName();
		String message = "Hi " + childName + "<br/>"+ 
		"We have created user's credentials for you to access your profile and update your status in time to time which helps us to coordinate and support you. "
		+ "<br/>"+ "<br/>"+
				
		"URL: app.rainbowhome.in"+ "<br/>"+
		"User Name: Same Child Id - "+child.getChildNo() +"<br/>"+
		"Password: "+cred.getPassword()+ "<br/>"+ "<br/>"+
		"Let's get connected,All the very best!!!"+ "<br/>"+
		"By"+ "<br/>"+
		"Rainbow Homes Program"+ "<br/>"+
		"Rainbow Foundation India"; 

		; 
		
		if(null != cred.getEmail() && !cred.getEmail().isEmpty()) {
			EmailData emailParams = new EmailData();
			emailParams.setFromAddress(fromAddress);
			emailParams.setMessage(message);
			emailParams.setSubject("User credentials for "+childName);
			emailParams.setToAddress(cred.getEmail());
			emailParams.setBccAdress("raju.rfi@rainbowhome.in, babu.rfi@rainbowhome.in");
			
			try {
				emailService.sendHtmlMail(emailParams);
				
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.error("Error in sending exit credentials",e);
				
			}
		}
		if(null != cred.getPhoneNo() && !cred.getPhoneNo().isEmpty()) {
			SMSDetails smsDetails = new SMSDetails();
			smsDetails.setMessage(message);
			smsDetails.setSender("RFIROR");
			smsDetails.setMobileNo(cred.getPhoneNo());
			smsService.sendSms(smsDetails);
			
		}
		return true;
		
	}

	

}
