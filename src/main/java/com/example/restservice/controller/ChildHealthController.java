package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildHealth;
import com.example.restservice.crud.ChildMedicalTreatment;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.crud.HealthChecklist;
import com.example.restservice.crud.HealthGrowthForm;
import com.example.restservice.dto.ChildHealthDTO;
import com.example.restservice.repository.ChildHealthRepository;
import com.example.restservice.repository.ChildMedicalTreatmentRepository;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.GeneralHealthRepository;
import com.example.restservice.repository.HealthChecklistRepository;
import com.example.restservice.repository.HealthGrowthFormRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildHealthController {
	
	@Autowired
	private GeneralHealthRepository generalHealthRepository;
	
	@Autowired 
	private ChildHealthRepository childHealthRepository;
	
	@Autowired
	private HealthChecklistRepository healthChecklistRepository;
	
	@Autowired
	private ChildMedicalTreatmentRepository childMedicalTreatmentRepository;
	
	@Autowired
	private HealthGrowthFormRepository healthGrowthFormRepository;
	
	@Autowired
	private ChildRepository childRepository;
	
	@GetMapping("/general-health")
	public ResponseEntity<List<GeneralHealth>> getCountry() {
		List<GeneralHealth> generalHealthList = generalHealthRepository.findAll();
		return ResponseEntity.ok().body(generalHealthList);
	}
	
	@GetMapping("/child-health/{healthNo}")
	@Cacheable("ChildHealth")
	public Optional<ChildHealth> getChildHealth(@PathVariable Integer healthNo) {
		return childHealthRepository.findChildHealthByHealthNo(healthNo);
	}
	
	@GetMapping("/child-health-all-records/{childNo}")
	@Cacheable("ChildHealthAllRecords")
	public List<ChildHealth> getAllHealthForAChild(@PathVariable Long childNo) {
		return childHealthRepository.findAllChildHealthByChildNo(childNo);
	}
	
	@PutMapping(path="/child-health/{healthNo}")
	@Caching(evict = {
		    @CacheEvict(value= "ChildHealth", allEntries=true),
		    @CacheEvict(value= "Child", allEntries=true)
		})
	public @Valid ChildHealth updateChildHealth(@PathVariable Integer healthNo, @Valid @RequestBody ChildHealthDTO childHealthDTO) {
		ChildHealth childHealth = new ChildHealth();
		childHealth.setHealthNo(healthNo);
		childHealth.setChildNo(childHealthDTO.getChildNo());
		childHealth.setHeight(childHealthDTO.getHeight());
		childHealth.setWeight(childHealthDTO.getWeight());
		childHealth.setGeneralHealth(childHealthDTO.getGeneralHealth());
		childHealth.setComments(childHealthDTO.getComments());
		childHealth.setHealthStatus(childHealthDTO.getHealthStatus());
		childHealth.setHealthDate(childHealthDTO.getHealthDate());
		
		if (null != childHealthDTO.getBloodGroup()) {
		  childRepository.saveChildBloodGroup(childHealthDTO.getBloodGroup(), childHealthDTO.getChildNo()); 
		}
		
		return childHealthRepository.save(childHealth);
	}
	
	@PostMapping(path="/child-health")
	public @Valid ChildHealth addChildHealth(@Valid @RequestBody ChildHealth childHealth) {
		return childHealthRepository.save(childHealth);
	}
	
	/* Child Health Checklist */
	
	@GetMapping("/health-checklists-for-child/{childNo}")
	@Cacheable("HealthChecklists")
	public List<HealthChecklist> getHealthCheckupForChild(@PathVariable Integer childNo) {
		return healthChecklistRepository.findByChildNo(childNo);
	}
	
	@GetMapping("/health-checklist/{healthChecklistNo}")
	@Cacheable("HealthChecklist")
	public Optional<HealthChecklist> getHealthCheckup(@PathVariable Integer healthChecklistNo) {
		return healthChecklistRepository.findByHealthChecklistNo(healthChecklistNo);
	}
	
	@PostMapping(path="/health-checklist")
	public @Valid HealthChecklist addHeathCheckup(@Valid @RequestBody HealthChecklist healthChecklist) {
		return healthChecklistRepository.save(healthChecklist);
	}
	
	@PutMapping(path="/health-checklist/{healthChecklistNo}")
	@CacheEvict (value= "HealthChecklist", allEntries=true)
	public @Valid HealthChecklist updateHealthChecklist(@PathVariable Integer healthChecklistNo, @Valid @RequestBody HealthChecklist healthChecklist) {
		healthChecklist.setHealthChecklistNo(healthChecklistNo);
		return healthChecklistRepository.save(healthChecklist);
	}
	
	/* Child Medical Treatment */

	@GetMapping("/medical-treatments-for-child/{childNo}")
	@Cacheable("MedicalTreatments")
	public List<ChildMedicalTreatment> getMedicalTreatmentForChild(@PathVariable Long childNo) {
		return childMedicalTreatmentRepository.findByChildNo(childNo);
	}
	
	@GetMapping("/medical-treatment/{childMedicalTreatmentNo}")
	@Cacheable("MedicalTreatment")
	public Optional<ChildMedicalTreatment> getMedicalTreatment(@PathVariable Integer childMedicalTreatmentNo) {
		return childMedicalTreatmentRepository.findByChildMedicalTreatmentNo(childMedicalTreatmentNo);
	}
	
	@PostMapping(path="/medical-treatment")
	public @Valid ChildMedicalTreatment addChildMedicalTreatment(@Valid @RequestBody ChildMedicalTreatment childMedicalTreatment) {
		return childMedicalTreatmentRepository.save(childMedicalTreatment);
	}
	
	@PutMapping(path="/medical-treatment/{childMedicalTreatmentNo}")
	@CacheEvict (value= "MedicalTreatment", allEntries=true)
	public @Valid ChildMedicalTreatment updateChildMedicalTreatment(@PathVariable Integer childMedicalTreatmentNo, @Valid @RequestBody ChildMedicalTreatment childMedicalTreatment) {
		childMedicalTreatment.setChildMedicalTreatmentNo(childMedicalTreatmentNo);
		return childMedicalTreatmentRepository.save(childMedicalTreatment);
	}
	
	/* Child Health Growth Form */
	
	@GetMapping("/health-growth-form-for-child/{childNo}")
	@Cacheable("healthgrowthforms")
	public List<HealthGrowthForm> getGrowthFormForChild(@PathVariable Long childNo) {
		return healthGrowthFormRepository.findByChildNo(childNo);
	}
	
	@GetMapping("/health-growth-form/{healthGrowthFormNo}")
	@Cacheable("healthgrowthform")
	public Optional<HealthGrowthForm> getGrowthForm(@PathVariable Integer healthGrowthFormNo) {
		return healthGrowthFormRepository.findByHealthGrowthFormNo(healthGrowthFormNo);
	}
	
	@PostMapping(path="/health-growth-form")
	public @Valid HealthGrowthForm addGrowthForm(@Valid @RequestBody HealthGrowthForm healthGrowthForm) {
		return healthGrowthFormRepository.save(healthGrowthForm);
	}
	
	@PutMapping(path="/health-growth-form/{healthGrowthFormNo}")
	@CacheEvict (value= "healthgrowthform", allEntries=true)
	public @Valid HealthGrowthForm updateGrowthForm(@PathVariable Integer healthGrowthFormNo, @Valid @RequestBody HealthGrowthForm healthGrowthForm) {
		healthGrowthForm.setHealthGrowthFormNo(healthGrowthFormNo);
		return healthGrowthFormRepository.save(healthGrowthForm);
	}
	
}