package com.example.restservice.service;

import com.example.restservice.controller.DonorTypeController;
import com.example.restservice.crud.DonorType;
import com.example.restservice.repository.DonorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorTypeService {

    @Autowired
    private DonorTypeRepository donorTypeRepository;

    public List<DonorType> getAllDonorType(){
        return donorTypeRepository.findAll();
    }

}
