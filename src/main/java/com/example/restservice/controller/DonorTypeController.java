package com.example.restservice.controller;


import com.example.restservice.crud.DonorType;
import com.example.restservice.service.DonorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DonorTypeController {

    @Autowired
    private DonorTypeService donorTypeService;

    @GetMapping("/donorType")
    public ResponseEntity<List<DonorType>> getAllDonorType(){
        List<DonorType> donorTypeList = donorTypeService.getAllDonorType();
        return ResponseEntity.ok(donorTypeList);
    }



}
