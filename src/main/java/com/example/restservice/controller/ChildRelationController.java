package com.example.restservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.example.restservice.crud.ChildFamily;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.PresentCondition;
import com.example.restservice.crud.Relation;
import com.example.restservice.repository.ChildFamilyRepository;
import com.example.restservice.repository.OccupationRepository;
import com.example.restservice.repository.PresentConditionRepository;
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
	
	@Autowired
	private PresentConditionRepository presentConditionRepo;

	

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
	@Cacheable("ChildFamily")
	public Optional<ChildFamily> getChildFamilyByFamilyNo(@PathVariable Integer familyNo) {
		return childFamilyRepository.findChildFamilyByFamilyNo(familyNo);
	}
	
	@GetMapping(path="/child-family/{childNo}", consumes = "application/json", produces = "application/json")
	public Optional<List<ChildFamily>> getChildFamily(@PathVariable Integer childNo) {
		Optional<List<ChildFamily>> childFamily = childFamilyRepository.findChildFamilyByChildNo(childNo);
		Map<Integer, String> conMap = getPresnetCondition();
		if(childFamily.isPresent()) {
			List<ChildFamily> familyList = childFamily.get();
			for(ChildFamily family : familyList) {
				family.setPresentconditionType(conMap.get(family.getPresentcondition()));
				Optional<Occupation> occupation = occupationRepository.findById(family.getOccupation());
				if(occupation.isPresent()) {
					family.setOccupationType(occupation.get().getOccupation());
					
				}
				
				Optional<Relation> relation = relationRepository.findById(family.getRelation());
				if(relation.isPresent()) {
					family.setRelationType(relation.get().getRelation());
				}
			}
		}
		return childFamily;
	}
	
	
	@PutMapping(path="/child-family")
	@CacheEvict (value= "ChildFamily", allEntries=true)
	public ChildFamily upadteChildFamily(@Valid @RequestBody ChildFamily childFamily) {
		return childFamilyRepository.save(childFamily);
	}
	
	private Map<Integer, String> getPresnetCondition(){
		List<PresentCondition> presenConList = presentConditionRepo.findAll();
		Map<Integer, String> conList = new HashMap<Integer, String>();
		for(PresentCondition condition : presenConList) {
			conList.put(condition.getPreconNo(), condition.getPrecon());
		}
		return conList;
	}
}