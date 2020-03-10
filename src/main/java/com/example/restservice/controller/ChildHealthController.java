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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildHealth;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.crud.HealthChecklistMultiple;
import com.example.restservice.crud.HealthChecklistSingle;
import com.example.restservice.repository.ChildHealthRepository;
import com.example.restservice.repository.GeneralHealthRepository;
import com.example.restservice.repository.HealthChecklistMultipleRepository;
import com.example.restservice.repository.HealthChecklistSingleRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildHealthController {
	
	@Autowired
	private GeneralHealthRepository generalHealthRepository;
	
	@Autowired 
	private ChildHealthRepository childHealthRepository;
	
	@Autowired
	private HealthChecklistSingleRepository healthChecklistSingleRepository;
	
	@Autowired
	private HealthChecklistMultipleRepository healthChecklistMultipleRepository;
	
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
	
	@GetMapping("/health-checkup-single/{childNo}")
	@Cacheable("HealthCheckupSingle")
	public Optional<HealthChecklistSingle> getHealthCheckupSingle(@PathVariable Integer childNo) {
		return healthChecklistSingleRepository.findByChildNo(childNo);
	}
	
	@PostMapping("/health-checkup-single")
	public @Valid HealthChecklistSingle addHeathCheckupSingle(@Valid HealthChecklistSingle healthChecklistSingle) {
		return healthChecklistSingleRepository.save(healthChecklistSingle);
	}
	
	@PutMapping(path="/health-checkup-single/{healthChecklistSingleNo}")
	@CachePut("HealthCheckupSingle")
	public @Valid HealthChecklistSingle updateHealthChecklistSingle(@PathVariable Long healthChecklistSingleNo, @Valid @RequestBody HealthChecklistSingle healthChecklistSingle) {
		return healthChecklistSingleRepository.save(healthChecklistSingle);
	}
	
	@GetMapping("/health-checkup-multiple/{childNo}")
	@Cacheable("HealthCheckupMultiple")
	public Optional<HealthChecklistMultiple> getHealthCheckupMultiple(@PathVariable Integer childNo) {
		return healthChecklistMultipleRepository.findByChildNo(childNo);
	}
	
	@PostMapping("/health-checkup-multiple")
	public @Valid HealthChecklistMultiple addHeathCheckupMultiple(@Valid HealthChecklistMultiple healthChecklistMultiple) {
		return healthChecklistMultipleRepository.save(healthChecklistMultiple);
	}

}