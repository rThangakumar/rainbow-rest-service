package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.restservice.FTPService;
import com.example.restservice.NotificationService;
import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildEnhanced;
import com.example.restservice.crud.ChildStatus;
import com.example.restservice.crud.ChildStayType;
import com.example.restservice.crud.CommitteeSuggestion;
import com.example.restservice.crud.CommitteeSuggestion_staff;
import com.example.restservice.crud.Community;
import com.example.restservice.crud.EducationStatus;
import com.example.restservice.crud.MotherTongue;
import com.example.restservice.crud.ParentalStatus;
import com.example.restservice.crud.ProfileDescription;
import com.example.restservice.crud.ReasonForAdmission;
import com.example.restservice.crud.ReferralSource;
import com.example.restservice.crud.Religion;
import com.example.restservice.crud.ScholarshipType;
import com.example.restservice.crud.Staff;
import com.example.restservice.repository.ChildEnhancedRepository;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.ChildStatusRepository;
import com.example.restservice.repository.ChildStayTypeRepository;
import com.example.restservice.repository.CommitteeSuggestionRepository;
import com.example.restservice.repository.CommunityRepository;
import com.example.restservice.repository.EducationStatusRepository;
import com.example.restservice.repository.MotherTongueRepository;
import com.example.restservice.repository.ParentalStatusRepository;
import com.example.restservice.repository.ProfileDescriptionRepository;
import com.example.restservice.repository.ReasonForAdmissionRepository;
import com.example.restservice.repository.ReferralSourceRepository;
import com.example.restservice.repository.ReligionRepository;
import com.example.restservice.repository.ScholarshipTypeRepository;
import com.example.restservice.repository.StaffRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildBasicController {

	@Autowired
	private ChildRepository childRepository;
	
	@Autowired
	private ChildEnhancedRepository childEnhancedRepository;
	
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
	
	@Autowired
	private ProfileDescriptionRepository profileDescriptionRepository;
	
	@Autowired
	private CommitteeSuggestionRepository committeeSuggestionRepository;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private FTPService FTPService;
	
	@Autowired
	private ChildStayTypeRepository childStayTypeRepository;
	
	@Autowired
	private ScholarshipTypeRepository scholarshipTypeRepository;
	
	@GetMapping("/scholarship-type")
	@Cacheable("ScholarshipType")
	public ResponseEntity<List<ScholarshipType>> getAllScholarshipType() {
		List<ScholarshipType> childStayType = scholarshipTypeRepository.findAll();
		return ResponseEntity.ok().body(childStayType);
	}
	
	@GetMapping("/childstay-type")
	@Cacheable("childStayType")
	public ResponseEntity<List<ChildStayType>> getAllChildStayType() {
		List<ChildStayType> childStayType = childStayTypeRepository.findAll();
		return ResponseEntity.ok().body(childStayType);
	}
	
	@GetMapping("/religions")
	@Cacheable("Religion")
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
	
	@GetMapping("/home-staff-list/{orgId}")
	public ResponseEntity<List<Staff>> getHomeStaffs(@PathVariable Integer orgId){
		List<Staff> staffList = staffRepository.findByOrgID(orgId);
		return ResponseEntity.ok().body(staffList);
		
	}
	
	@GetMapping("/home-staff-list")
	public ResponseEntity<List<Staff>> getAllStaffs(){
		List<Staff> staffList = staffRepository.findAll();
		return ResponseEntity.ok().body(staffList);
		
	}
	
	@GetMapping("/children/{homeNo}")
	public ResponseEntity<List<ChildEnhanced>> getChildrenInTheHome(@PathVariable Integer homeNo){
		List<ChildEnhanced> childrenInTheHome = childEnhancedRepository.findByRainbowHomeNumber(homeNo);
		return ResponseEntity.ok(childrenInTheHome);
	}
	
	@PostMapping(path="/child")
	public @Valid Child addChild(@Valid @RequestBody Child child) {
		Child savedChildDetails = childRepository.save(child);
		notificationService.sendAddChildNotification(savedChildDetails, child.getRainbowHomeNumber());
		return savedChildDetails;

	}
	
	@PostMapping(value = "/child-with-image/{orgId}")
	public @Valid Child addChild(@RequestParam("file") MultipartFile file, @RequestParam("child") Child child, @PathVariable Integer orgId) {
		Child savedChildDetails = childRepository.save(child);
		FTPService.uploadFile(savedChildDetails.getChildNo(), file);
		notificationService.sendAddChildNotification(savedChildDetails, orgId);
		return savedChildDetails;

	}
	
	@GetMapping(path="/child/{childNo}")
	@Cacheable("Child")
	public Optional<Child> getChild(@PathVariable Long childNo) {
		return childRepository.findById(childNo);
	}
	
	@PutMapping(path="/child/{childNo}")
	@CacheEvict (value= "Child", allEntries=true)
	public Child updateChild(@PathVariable Long childNo, @Valid @RequestBody Child child) {
		child.setChildNo(childNo);
		return childRepository.save(child);
	}
	
	/* Child Profile Description */
	
	@PostMapping(path="/child-profile-description")
	public @Valid ProfileDescription addProfileDescription(@Valid @RequestBody ProfileDescription profileDescription){
		return profileDescriptionRepository.save(profileDescription);
	}
	
	@GetMapping(path="/child-profile-description/{profileDescriptionNo}")
	@Cacheable("ChildProfile")
	public Optional<ProfileDescription> getProfileDescription(@PathVariable Long profileDescriptionNo) {
		return profileDescriptionRepository.findById(profileDescriptionNo);
	}
	
	@GetMapping(path="/child-profile-all-description/{childNo}")
	public Optional<List<ProfileDescription>> getAllProfileDescription(@PathVariable Long childNo) {
		return profileDescriptionRepository.findAllByChildNo(childNo);
	}
	
	@PutMapping(path="/child-profile-description/{profileDescriptionNo}")
	@CacheEvict (value= "ChildProfile", allEntries=true)
	public ProfileDescription updateProfileDescription(@PathVariable Long profileDescriptionNo, @Valid @RequestBody ProfileDescription profileDescription) {
		profileDescription.setProfileDescriptionNo(profileDescriptionNo);
		return profileDescriptionRepository.save(profileDescription);
	}
	
	/* Child Admission Committee Suggestion */
	
	@PostMapping(path="/admission-committee-suggestion")
	public @Valid CommitteeSuggestion addAdmissionCommitteeSuggestion(@Valid @RequestBody CommitteeSuggestion committeeSuggestion){
		// my changes - to add parent for the Child
		List<CommitteeSuggestion_staff> staffNumber = committeeSuggestion.getStaffNumber();
		for (CommitteeSuggestion_staff lang : staffNumber) {
			lang.setParent(committeeSuggestion);
		}
		return committeeSuggestionRepository.save(committeeSuggestion);
	}
	
	@GetMapping(path="/admission-committee-suggestion/{committeeSuggestionId}")
	@Cacheable("CommitteeSuggestion")
	public Optional<CommitteeSuggestion> getCommitteeSuggestion(@PathVariable Long committeeSuggestionId) {
		return committeeSuggestionRepository.findById(committeeSuggestionId);
	}
	
	@GetMapping(path="/admission-all-committee-suggestions/{childNo}")
	@CacheEvict (value= "CommitteeSuggestion", allEntries=true)
	public Optional<List<CommitteeSuggestion>> getAllCommitteeSuggestions(@PathVariable Long childNo) {
		return committeeSuggestionRepository.findAllByChildNo(childNo);
	}
	
	@PutMapping(path="/admission-committee-suggestion/{committeeSuggestionNo}")
	@Cacheable("CommitteeSuggestion")
	public @Valid CommitteeSuggestion updateCommitteeSuggestion(@PathVariable Long committeeSuggestionNo, @Valid @RequestBody CommitteeSuggestion committeeSuggestion) {
		committeeSuggestion.setCommitteeSuggestionNo(committeeSuggestionNo);
		
		List<CommitteeSuggestion_staff> staffNumber = committeeSuggestion.getStaffNumber();
		for (CommitteeSuggestion_staff lang : staffNumber) {
			lang.setParent(committeeSuggestion);
		}
		
		return committeeSuggestionRepository.save(committeeSuggestion);
	}
	
}