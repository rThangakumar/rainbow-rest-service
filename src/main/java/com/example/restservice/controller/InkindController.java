package com.example.restservice.controller;


import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Inkind;
import com.example.restservice.service.DonorTypeService;
import com.example.restservice.service.InkindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class InkindController {

    @Autowired
    private InkindService inkindService;

    @GetMapping("/inkind")
    public ResponseEntity<List<Inkind>> getAllDonorType(){
        List<Inkind> inkindList = inkindService.getAllInkindList();
        return ResponseEntity.ok(inkindList);
    }



}
