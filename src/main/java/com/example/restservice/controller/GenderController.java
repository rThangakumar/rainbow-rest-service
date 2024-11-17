package com.example.restservice.controller;

import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Gender;
import com.example.restservice.service.DonorTypeService;
import com.example.restservice.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("api/v1")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("/gender")
    public ResponseEntity<List<Gender>> getAllGenderType(){
        List<Gender> genderList = genderService.getAllGenderList();
        return ResponseEntity.ok(genderList);
    }

}
