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
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildClass;
import com.example.restservice.crud.ChildEducation;
import com.example.restservice.crud.ExamResults;
import com.example.restservice.crud.SchoolType;
import com.example.restservice.repository.ChildClassRepository;
import com.example.restservice.repository.ChildEducationRepository;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.ExamResultsRepository;
import com.example.restservice.repository.SchoolTypeRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildEducationController {

	@Autowired
	private ChildClassRepository childClassRepository;
	
	@Autowired
	private SchoolTypeRepository schoolTypeRepository;
	
	@Autowired
	private ChildEducationRepository childEducationRepository;
	
	@Autowired
	private ExamResultsRepository examResultsRepository;
	
	@Autowired
	private ChildRepository childRepository;
		
	@GetMapping("/studying-class")
	@Cacheable("StudyingClass")
	public ResponseEntity<List<ChildClass>> getStudyingClass() {
		List<com.example.restservice.crud.ChildClass> childClass = childClassRepository.findAll();
		return ResponseEntity.ok().body(childClass);
	}
	@GetMapping("/school-type")
	public ResponseEntity<List<SchoolType>> getSchoolType() {
		List<SchoolType> schoolType = schoolTypeRepository.findAll();
		return ResponseEntity.ok().body(schoolType);
	}
	
	@PostMapping(path="/child-education", consumes = "application/json", produces = "application/json")
	public @Valid ChildEducation addChildEducation(@Valid @RequestBody ChildEducation childEducation) {
		return childEducationRepository.save(childEducation);
	}
	
	@GetMapping(path="/child-education/{childNo}", consumes = "application/json", produces = "application/json")
//	@Cacheable("ChildEducation")
	public Optional<List<ChildEducation>> getChildEducation(@PathVariable Integer childNo) {
		Integer previousClass = null;
		String dropoutReason = null;

		Optional<Child> childList = childRepository.findById(Long.valueOf(childNo));
		if(childList.isPresent()) {
			previousClass = childList.get().getPreviousClassStudied();
			dropoutReason = childList.get().getDropoutReason();
		}
		
		Optional<List<ChildEducation>> childEducation = childEducationRepository.findByChildNo(childNo);
		if(childEducation.isPresent()) {
			for(ChildEducation ce : childEducation.get()) {
				ce.setPreviousClassStudied(previousClass);
				ce.setDropoutReason(dropoutReason);
			}
		}
		
		return childEducation;
	}
	
	
	@PutMapping(path="/child-education")
	@CacheEvict (value= "ChildEducation", allEntries=true)
	public ChildEducation upadteChildEducation(@Valid @RequestBody ChildEducation childEducation) {
		Optional<Child> childList = childRepository.findById(Long.valueOf(childEducation.getChildNo()));
		if(childList.isPresent()) {
			Child child = childList.get();
			child.setPreviousClassStudied(childEducation.getPreviousClassStudied());
			child.setDropoutReason(childEducation.getDropoutReason());
			childRepository.save(child);
			System.out.println("Saved ChildBasic successfully");
		}
		
		return childEducationRepository.save(childEducation);
	}
	
	@PostMapping(path="/exam-results", consumes = "application/json", produces = "application/json")
	public @Valid ExamResults addExamResults(@Valid @RequestBody ExamResults examResults) {
		return examResultsRepository.save(examResults);
	}
	
	@GetMapping(path="/exam-results/{childNo}", consumes = "application/json", produces = "application/json")
	public Optional<List<ExamResults>> getExamResultsByChild(@PathVariable Integer childNo) {
		return examResultsRepository.findByChildNo(childNo);
	}
	
	
	@PutMapping(path="/exam-results")
	public ExamResults upadteExamResults(@Valid @RequestBody ExamResults examResults) {
		return examResultsRepository.save(examResults);
	}
		
}