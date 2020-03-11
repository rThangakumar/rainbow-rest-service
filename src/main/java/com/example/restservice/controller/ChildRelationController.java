package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.ChildFamily;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.Relation;
import com.example.restservice.repository.ChildFamilyRepository;
import com.example.restservice.repository.OccupationRepository;
import com.example.restservice.repository.RelationRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildRelationController {

	@Autowired
	private RelationRepository relationRepository;

	@Autowired
	private OccupationRepository occupationRepository;
	
	@Autowired
	private ChildFamilyRepository childFamilyRepository;
	

	@GetMapping("/relations")
	public ResponseEntity<List<Relation>> getRelation() {
		List<Relation> relationList = relationRepository.findAll();
		return ResponseEntity.ok().body(relationList);
	}
	@GetMapping("/occupations")
	public ResponseEntity<List<Occupation>> getOccupation() {
		List<Occupation> occuationList = occupationRepository.findAll();
		return ResponseEntity.ok().body(occuationList);
	}
	
	@PostMapping(path="/child-family", consumes = "application/json", produces = "application/json")
	public @Valid ChildFamily addChildFamily(@Valid @RequestBody ChildFamily childFamily) {
		return childFamilyRepository.save(childFamily);
	}
	
	@GetMapping(path="/family/{familyNo}", consumes = "application/json", produces = "application/json")
	public Optional<ChildFamily> getChildFamilyByFamilyNo(@PathVariable Integer familyNo) {
		return childFamilyRepository.findChildFamilyByFamilyNo(familyNo);
	}
	
	@GetMapping(path="/child-family/{childNo}", consumes = "application/json", produces = "application/json")
	public Optional<List<ChildFamily>> getChildFamily(@PathVariable Integer childNo) {
		return childFamilyRepository.findChildFamilyByChildNo(childNo);
	}
	
	
	@PutMapping(path="/child-family")
	public ChildFamily upadteChildFamily(@Valid @RequestBody ChildFamily childFamily) {
		return childFamilyRepository.save(childFamily);
	}
}