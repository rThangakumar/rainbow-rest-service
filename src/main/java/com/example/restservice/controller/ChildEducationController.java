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
import com.example.restservice.crud.SchoolType;
import com.example.restservice.repository.ChildClassRepository;
import com.example.restservice.repository.ChildEductionRepository;
import com.example.restservice.repository.SchoolTypeRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildEducationController {

	@Autowired
	private ChildClassRepository childClassRepository;
	
	@Autowired
	private SchoolTypeRepository schoolTypeRepository;
	
	@Autowired
	private ChildEductionRepository childEductionRepository;
	
		
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
		return childEductionRepository.save(childEducation);
	}
	
	@GetMapping(path="/child-education/{childNo}", consumes = "application/json", produces = "application/json")
	@Cacheable("ChildEducation")
	public Optional<List<ChildEducation>> getChildEducation(@PathVariable Integer childNo) {
		return childEductionRepository.findByChildNo(childNo);
	}
	
	
	@PutMapping(path="/child-education")
	@CacheEvict (value= "ChildEducation", allEntries=true)
	public ChildEducation upadteChildEducation(@Valid @RequestBody ChildEducation childEducation) {
		return childEductionRepository.save(childEducation);
	}
		
}