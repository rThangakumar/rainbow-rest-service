package com.example.restservice.service;

import com.example.restservice.crud.ProgramType;
import com.example.restservice.repository.ProgramTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramTypeService {

    @Autowired
    private ProgramTypeRepository programTypeRepository;

    public List<ProgramType> getAllProgramType(){
        return programTypeRepository.findAll();
    }
}
