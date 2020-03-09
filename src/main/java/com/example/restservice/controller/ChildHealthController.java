package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildHealth;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.repository.ChildHealthRepository;
import com.example.restservice.repository.GeneralHealthRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildHealthController {
	
	@Autowired
	private GeneralHealthRepository generalHealthRepository;
	
	@Autowired 
	private ChildHealthRepository childHealthRepository;
	
	@GetMapping("/general-health")
	public ResponseEntity<List<GeneralHealth>> getCountry() {
		List<GeneralHealth> generalHealthList = generalHealthRepository.findAll();
		return ResponseEntity.ok().body(generalHealthList);
	}
	
	@GetMapping("/child-health/{healthNo}")
	@Cacheable("ChildHealth")
	public Optional<ChildHealth> getChildHealth(@PathVariable Integer healthNo) {
		return childHealthRepository.findByHealthNo(healthNo);
	}
	
	@PutMapping("/child-health/{healthNo}")
	@CachePut("ChildHealth")
	public @Valid ChildHealth updateChildHealth(@Valid ChildHealth childHealth) {
		return childHealthRepository.save(childHealth);
	}
	
	@PostMapping("/child-health")
	public @Valid ChildHealth addChildHealth(@Valid ChildHealth childHealth) {
		return childHealthRepository.save(childHealth);
	}

}