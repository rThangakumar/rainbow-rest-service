package com.example.restservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.Grade;
import com.example.restservice.crud.Identification;
import com.example.restservice.crud.User;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.repository.*;

@RestController
@RequestMapping("/api/v1")
public class ChildController {

	@Autowired
	private ChildRepository childRepository;
	
	@Autowired
	private IdentificationRepository identificationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping("/child/{id}")
	public ResponseEntity<Child> getChildById(@PathVariable(value = "id") Long childId) throws ResourceNotFoundException {
		Child child = childRepository.findById(childId)
				.orElseThrow(() -> new ResourceNotFoundException("Child not found for this id ::"+childId));
		return ResponseEntity.ok().body(child);
	}
	
	@GetMapping("/child")
	public ResponseEntity<Child> getAllChild() throws ResourceNotFoundException{
		List<Child> child = childRepository.findAll();
		return ResponseEntity.ok().body(child.get(0));
	}
	
	@GetMapping("/identification/{id}")
	public ResponseEntity<Identification> getIdbyId(@PathVariable(value = "id") Long identificationId) throws ResourceNotFoundException {
		Identification identification = identificationRepository.findById(identificationId)
				.orElseThrow(() -> new ResourceNotFoundException("Identification not found for this id ::"+identificationId));
		return ResponseEntity.ok().body(identification);
		
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllIds(){
		
		//User user1 = new User("Alice", 23);
		//User user2 = new User("Bob", 38);
		//this.userRepository.save(user1);
		//this.userRepository.save(user2);
		
		return userRepository.findAll();
	}
	
	@GetMapping("/grades")
	public @ResponseBody Iterable<Grade> getAllGrades(){
		return gradeRepository.findAll();
	}
	
	
}