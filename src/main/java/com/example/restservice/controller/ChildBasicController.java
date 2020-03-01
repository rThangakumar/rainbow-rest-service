package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildStatus;
import com.example.restservice.crud.Community;
import com.example.restservice.crud.EducationStatus;
import com.example.restservice.crud.MotherTongue;
import com.example.restservice.crud.ParentalStatus;
import com.example.restservice.crud.ReasonForAdmission;
import com.example.restservice.crud.ReferralSource;
import com.example.restservice.crud.Religion;
import com.example.restservice.crud.Staff;
import com.example.restservice.repository.*;

@RestController
@RequestMapping("/api/v1")
public class ChildBasicController {

	@Autowired
	private ChildRepository childRepository;
	
	@Autowired
	private ReligionRepository religionRepository;
	
	@Autowired
	private CommunityRepository communityRepository;
	
	@Autowired
	private MotherTongueRepository motherTongueRepository;
	
	@Autowired
	private ParentalStatusRepository parentalStatusRepository;
	
	@Autowired
	private ReasonForAdmissionRepository reasonForAdmissionRepository;
	
	@Autowired
	private EducationStatusRepository educationStatusRepository;
	
	@Autowired
	private ReferralSourceRepository referralSourceRepository;
	
	@Autowired
	private ChildStatusRepository childStatusRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@GetMapping("/religions")
	public ResponseEntity<List<Religion>> getAllReligions() {
		List<Religion> religions = religionRepository.findAll();
		return ResponseEntity.ok().body(religions);
	}
	
	@GetMapping("/communities")
	public ResponseEntity<List<Community>> getAllCommunities() {
		List<Community> communities = communityRepository.findAll();
		return ResponseEntity.ok().body(communities);
	}
	
	@GetMapping("/mother-tongues")
	public ResponseEntity<List<MotherTongue>> getAllMotherTongues() {
		List<MotherTongue> motherTongues = motherTongueRepository.findAll();
		return ResponseEntity.ok().body(motherTongues);
	}
	
	@GetMapping("/parental-statuses")
	public ResponseEntity<List<ParentalStatus>> getAllParentalStatus() {
		List<ParentalStatus> parentalStatuses = parentalStatusRepository.findAll();
		return ResponseEntity.ok().body(parentalStatuses);
	}
	
	@GetMapping("/admission-reasons")
	public ResponseEntity<List<ReasonForAdmission>> getAllReasonsForAdmission() {
		List<ReasonForAdmission> reasonForAdmissions = reasonForAdmissionRepository.findAll();
		return ResponseEntity.ok().body(reasonForAdmissions);
	}
	
	@GetMapping("/education-statuses")
	public ResponseEntity<List<EducationStatus>> getAllEducationStatuses() {
		List<EducationStatus> educationStatuses = educationStatusRepository.findAll();
		return ResponseEntity.ok().body(educationStatuses);
	}
	
	@GetMapping("/referral-sources")
	public ResponseEntity<List<ReferralSource>> getAllReferralSources() {
		List<ReferralSource> referralSources = referralSourceRepository.findAll();
		return ResponseEntity.ok().body(referralSources);
	}
	
	@GetMapping("/child-statuses")
	public ResponseEntity<List<ChildStatus>> getAllChildStatuses() {
		List<ChildStatus> childStatuses = childStatusRepository.findAll();
		return ResponseEntity.ok().body(childStatuses);
	}
	
	@GetMapping("/home-staff-list")
	public ResponseEntity<List<Staff>> getAllStaffsInAHome(){
		List<Staff> staffList = staffRepository.findAll();
		return ResponseEntity.ok().body(staffList);
		
	}
	
	@GetMapping("/children")
	public ResponseEntity<Child> getAllChild(){
		List<Child> child = childRepository.findAll();
		return ResponseEntity.ok().body(child.get(0));
	}
	
}