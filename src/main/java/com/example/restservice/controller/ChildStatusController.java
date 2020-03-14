package com.example.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.ChildLeavingReason;
import com.example.restservice.crud.ChildLeftPlace;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.repository.ChildLeavingReasonRepository;
import com.example.restservice.repository.ChildLeftPlaceRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildStatusController {
	
	@Autowired
	private ChildLeavingReasonRepository childLeavingReasonRepository;
	
	@Autowired
	private ChildLeftPlaceRepository childLeftPlaceRepository;
	
	@GetMapping("/child-leaving-reasons")
	public ResponseEntity<List<ChildLeavingReason>> getChildLeavingReasons() {
		List<ChildLeavingReason> childLeavingReasons = childLeavingReasonRepository.findAll();
		return ResponseEntity.ok().body(childLeavingReasons);
	}
	
	@GetMapping("/child-left-places")
	public ResponseEntity<List<ChildLeftPlace>> getChildLeftplaces() {
		List<ChildLeftPlace> childLeftPlaces = childLeftPlaceRepository.findAll();
		return ResponseEntity.ok().body(childLeftPlaces);
	}

}