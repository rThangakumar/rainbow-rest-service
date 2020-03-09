package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildClass;
import com.example.restservice.crud.Country;
import com.example.restservice.crud.District;
import com.example.restservice.crud.SchoolType;
import com.example.restservice.crud.State;
import com.example.restservice.repository.ChildClassRepository;
import com.example.restservice.repository.ChildCommunicationRepository;
import com.example.restservice.repository.CountryRepository;
import com.example.restservice.repository.DistrictRepository;
import com.example.restservice.repository.SchoolTypeRepository;
import com.example.restservice.repository.StateRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildCommunicationController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private ChildCommunicationRepository childCommunicationRepository;

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountry() {
		List<Country> countryList = countryRepository.findAll();
		return ResponseEntity.ok().body(countryList);
	}
	@GetMapping("/states")
	public ResponseEntity<List<State>> getState() {
		List<State> stateList = stateRepository.findAll();
		return ResponseEntity.ok().body(stateList);
	}
	@GetMapping("/districts")
	public ResponseEntity<List<District>> getDistrict() {
		List<District> distList = districtRepository.findAll();
		return ResponseEntity.ok().body(distList);
	}
	
	@GetMapping("/child-communication/{addressNo}")
	@Cacheable("ChildCommunication")
	public Optional<ChildAddress> getChildCommunication(@PathVariable Integer addressNo) {
		return childCommunicationRepository.findByAddressNo(addressNo);
	}
	@PutMapping("/child-communication")
	@CachePut("ChildCommunication")
	public @Valid ChildAddress updateChildCommunication(@Valid ChildAddress childAddress) {
		return childCommunicationRepository.save(childAddress);
	}
	@PostMapping("/child-communication")
	public @Valid ChildAddress addChildCommunication(@Valid @RequestBody ChildAddress childAddress) {
		return childCommunicationRepository.save(childAddress);
	}
	
	@DeleteMapping("/child-communication")
	public void deleteChildCommunication(@Valid ChildAddress childAddress) {
		childCommunicationRepository.delete(childAddress);
	}
	
}