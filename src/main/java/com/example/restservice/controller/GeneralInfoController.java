package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildGeneralInfo;
import com.example.restservice.crud.DifferentlyAbledGroup;
import com.example.restservice.crud.Identification;
import com.example.restservice.crud.MarkType;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.Staff;
import com.example.restservice.crud.StayReason;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.DifferentlyAbledGroupRepository;
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
	private DifferentlyAbledGroupRepository differentlyAbledGroupRepository;
	
	@Autowired
	private ChildRepository childRepository;
	
	@GetMapping("/identifications")
	public ResponseEntity<List<Identification>> getIdentifications(){
		List<Identification> identificationList = identificationRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
	}
	
	@GetMapping("/mark-types")
	public ResponseEntity<List<MarkType>> getMarkTypes(){
		List<MarkType> markTypes = markTypeRepository.findAll();
		return ResponseEntity.ok().body(markTypes);	
	}
	
	@GetMapping("/street-occupations")
	public ResponseEntity<List<Occupation>> getOccupations(){
		List<Occupation> streetOccupations = occupationRepository.findAll();
		return ResponseEntity.ok().body(streetOccupations);	
	}
	
	@GetMapping("/stay-reasons")
	public ResponseEntity<List<StayReason>> getStayReasons(){
		List<StayReason> stayReasons = stayReasonRepository.findAll();
		return ResponseEntity.ok().body(stayReasons);
	}
	
	@GetMapping("/differently-abled-groups")
	public ResponseEntity<List<DifferentlyAbledGroup>> getDifferentlyAbledGroups(){
		List<DifferentlyAbledGroup> differentlyAbledGroups = differentlyAbledGroupRepository.findAll();
		return ResponseEntity.ok().body(differentlyAbledGroups);
	}
	
	@GetMapping("/child-general-info/{childNo}")
	@Cacheable("ChildGeneralInfo")
	public ResponseEntity<ChildGeneralInfo> getChildGeneralInfo(@PathVariable Long childNo){
		Optional<Child> childInfo = childRepository.findById(childNo);
		ChildGeneralInfo childGeneralInfo = new ChildGeneralInfo();
		childGeneralInfo.setDifferentlyAbledGroup(childInfo.get().getDifferentlyAbledGroup());
		childGeneralInfo.setIdentificationMark1(childInfo.get().getIdentificationMark1());
		childGeneralInfo.setIdentificationMark2(childInfo.get().getIdentificationMark2());
		childGeneralInfo.setOccupation(childInfo.get().getOccupation());
		childGeneralInfo.setStayReason(childInfo.get().getStayReason());
		return ResponseEntity.ok().body(childGeneralInfo);
	}
	
	@PutMapping("/child-general-info/{childNo}")
	@CacheEvict (value= "ChildGeneralInfo", allEntries=true)
	public ResponseEntity<Child> updateChildGeneralInfo(@PathVariable Integer childNo, @Valid @RequestBody Child childInfo){
		ChildGeneralInfo childGeneralInfo = new ChildGeneralInfo();
		childGeneralInfo.setChildNo(childNo);
		childGeneralInfo.setDifferentlyAbledGroup(childInfo.getDifferentlyAbledGroup());
		childGeneralInfo.setIdentificationMark1(childInfo.getIdentificationMark1());
		childGeneralInfo.setIdentificationMark2(childInfo.getIdentificationMark2());
		childGeneralInfo.setOccupation(childInfo.getOccupation());
		childGeneralInfo.setStayReason(childInfo.getStayReason());
		return childRepository.save(childInfo.getIdentificationMark1(), childInfo.getIdentificationMark2(),childInfo.getStayReason(),childInfo.getOccupation(),childInfo.getDifferentlyAbledGroup(),childNo);
	}

}