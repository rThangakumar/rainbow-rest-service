package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildGeneralInfo;
import com.example.restservice.crud.Identification;
import com.example.restservice.crud.MarkType;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.Staff;
import com.example.restservice.crud.StayReason;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.IdentificationRepository;
import com.example.restservice.repository.MarkTypeRepository;
import com.example.restservice.repository.OccupationRepository;
import com.example.restservice.repository.StayReasonRepository;

@RestController
@RequestMapping("/api/v1")
public class GeneralInfoController {
	
	@Autowired
	private IdentificationRepository identificationRepository;
	
	@Autowired
	private MarkTypeRepository markTypeRepository;
	
	@Autowired
	private OccupationRepository occupationRepository;
	
	@Autowired
	private StayReasonRepository stayReasonRepository;
	
	@Autowired
	private ChildRepository childRepository;
	
	@GetMapping("/identifications")
	public ResponseEntity<List<Identification>> getIdentifications(){
		List<Identification> identificationList = identificationRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
	}
	
	@GetMapping("/mark-types")
	public ResponseEntity<List<MarkType>> getMarkTypes(){
		List<MarkType> identificationList = markTypeRepository.findAll();
		return ResponseEntity.ok().body(identificationList);	
	}
	
	@GetMapping("/street-occupations")
	public ResponseEntity<List<Occupation>> getOccupations(){
		List<Occupation> identificationList = occupationRepository.findAll();
		return ResponseEntity.ok().body(identificationList);	
	}
	
	@GetMapping("/stay-reasons")
	public ResponseEntity<List<StayReason>> getStayReasons(){
		List<StayReason> identificationList = stayReasonRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
	}
	
	@GetMapping("/child-general-info/{childNo}")
	@Cacheable("ChildGeneralInfo")
	public ResponseEntity<ChildGeneralInfo> getChildGeneralInfo(@PathVariable Long childNo){
		Optional<Child> childInfo = childRepository.findById(childNo);
		ChildGeneralInfo childGeneralInfo = new ChildGeneralInfo();
		childGeneralInfo.setDifferentlyAbledGroup(childInfo.get().getDifferntlyAbledGroup());
		childGeneralInfo.setIdentificationMark1(childInfo.get().getIdentificationMark1());
		childGeneralInfo.setIdentificationMark2(childInfo.get().getIdentificationMark2());
		childGeneralInfo.setOccupation(childInfo.get().getOccupation());
		childGeneralInfo.setStayReason(childInfo.get().getStayReason());
		return ResponseEntity.ok().body(childGeneralInfo);
	}

}