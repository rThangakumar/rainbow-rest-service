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

import com.example.restservice.crud.ChildHealth;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.crud.HealthChecklist;
import com.example.restservice.repository.ChildHealthRepository;
import com.example.restservice.repository.GeneralHealthRepository;
import com.example.restservice.repository.HealthChecklistRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildHealthController {
	
	@Autowired
	private GeneralHealthRepository generalHealthRepository;
	
	@Autowired 
	private ChildHealthRepository childHealthRepository;
	
	@Autowired
	private HealthChecklistRepository healthChecklistRepository;
	
	@GetMapping("/general-health")
	public ResponseEntity<List<GeneralHealth>> getCountry() {
		List<GeneralHealth> generalHealthList = generalHealthRepository.findAll();
		return ResponseEntity.ok().body(generalHealthList);
	}
	
	@GetMapping("/child-health/{healthNo}")
	@Cacheable("ChildHealth")
	public Optional<ChildHealth> getChildHealth(@PathVariable Long healthNo) {
		return childHealthRepository.findChildHealthByHealthNo(healthNo);
	}
	
	@GetMapping("/child-health-all-records/{childNo}")
	@Cacheable("ChildHealthAllRecords")
	public Optional<ChildHealth> getAllHealthForAChild(@PathVariable Long childNo) {
		return childHealthRepository.findChildHealthByChildNo(childNo);
	}
	
	@PutMapping(path="/child-health/{healthNo}")
	@CachePut("ChildHealth")
	public @Valid ChildHealth updateChildHealth(@PathVariable Long healthNo, @Valid @RequestBody ChildHealth childHealth) {
		childHealth.setHealthNo(healthNo);
		return childHealthRepository.save(childHealth);
	}
	
	@PostMapping(path="/child-health")
	public @Valid ChildHealth addChildHealth(@Valid @RequestBody ChildHealth childHealth) {
		return childHealthRepository.save(childHealth);
	}
	
	@GetMapping("/health-checklist/{childNo}")
	@Cacheable("HealthChecklist")
	public Optional<HealthChecklist> getHealthCheckup(@PathVariable Integer childNo) {
		return healthChecklistRepository.findByChildNo(childNo);
	}
	
	@PostMapping(path="/health-checklist")
	public @Valid HealthChecklist addHeathCheckupMultiple(@Valid @RequestBody HealthChecklist healthChecklist) {
		return healthChecklistRepository.save(healthChecklist);
	}
	
	@PutMapping(path="/health-checklist/{healthChecklistNo}")
	@CachePut("HealthChecklist")
	public @Valid HealthChecklist updateHealthChecklistMultiple(@PathVariable Long healthChecklistNo, @Valid @RequestBody HealthChecklist healthChecklist) {
		healthChecklist.setHealthChecklistNo(healthChecklistNo);
		return healthChecklistRepository.save(healthChecklist);
	}

}