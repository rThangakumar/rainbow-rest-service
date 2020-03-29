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

import com.example.restservice.crud.ChildFollowup;
import com.example.restservice.repository.ChildFollowupRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildFollowupController {
	
	@Autowired
	private ChildFollowupRepository childFollowupRepository;
	
	@GetMapping("/child-followup-all/{ChildNo}")
	@Cacheable("Childfollowupall")
	public ResponseEntity<List<ChildFollowup>> getChildfollowups(@PathVariable Long ChildNo) {
		List<ChildFollowup> childFollowups = childFollowupRepository.findAllByChildNo(ChildNo);
		return ResponseEntity.ok().body(childFollowups);
	}
	
	@GetMapping("/child-followup/{childFollowupNo}")
	@Cacheable("Childfollowup")
	public ResponseEntity<Optional<ChildFollowup>> getChildfollowup(@PathVariable Integer childFollowupNo) {
		Optional<ChildFollowup> childFollowup = childFollowupRepository.findById(childFollowupNo);
		return ResponseEntity.ok().body(childFollowup);
	}
	
	@PutMapping("/child-followup/{childFollowupNo}")
	@CacheEvict (value= "Childfollowup", allEntries=true)
	public ChildFollowup updateChildFollowup(@PathVariable Integer childFollowupNo, @Valid @RequestBody ChildFollowup childFollowup) {
		childFollowup.setChildFollowupNo(childFollowupNo);
		return childFollowupRepository.save(childFollowup);
	}
	
	@PostMapping(path="/child-followup")
	public @Valid ChildFollowup addChildFollowup(@Valid @RequestBody ChildFollowup childFollowup){
		return childFollowupRepository.save(childFollowup);
	}
}