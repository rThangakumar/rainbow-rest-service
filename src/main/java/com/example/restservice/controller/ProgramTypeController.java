package com.example.restservice.controller;
import com.example.restservice.crud.ProgramType;
import com.example.restservice.service.ProgramTypeService;
import com.example.restservice.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProgramTypeController {

    @Autowired
    private ProgramTypeService programTypeService;

    @GetMapping("/programType")
    public ResponseEntity<List<ProgramType>> getAllProgramType(){
        List<ProgramType> programType = programTypeService.getAllProgramType();
        return ResponseEntity.ok(programType);
    }


}
