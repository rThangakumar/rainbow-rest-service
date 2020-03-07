package com.example.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Identification;
import com.example.restservice.crud.MarkType;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.Staff;
import com.example.restservice.repository.IdentificationRepository;
import com.example.restservice.repository.MarkTypeRepository;
import com.example.restservice.repository.OccupationRepository;

@RestController
@RequestMapping("/api/v1")
public class GeneralInfoController {
	
	@Autowired
	private IdentificationRepository identificationRepository;
	
	@Autowired
	private MarkTypeRepository markTypeRepository;
	
	@Autowired
	private OccupationRepository occupationRepository;
	
	@GetMapping("/identifications")
	public ResponseEntity<List<Identification>> getIdentifications(){
		List<Identification> identificationList = identificationRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
		
	}
	
	@GetMapping("/mark-types")
	public ResponseEntity<List<MarkType>> getMarkTypes(){
		List<MarkType> identificationList = markTypeRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
		
	}
	
	@GetMapping("/occupations")
	public ResponseEntity<List<Occupation>> getOccupations(){
		List<Occupation> identificationList = occupationRepository.findAll();
		return ResponseEntity.ok().body(identificationList);
		
	}

}