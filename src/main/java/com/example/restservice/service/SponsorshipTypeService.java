package com.example.restservice.service;


import com.example.restservice.crud.SponsorshipType;
import com.example.restservice.repository.SponsorRepository;
import com.example.restservice.repository.SponsorshipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorshipTypeService {

    @Autowired
    private SponsorshipTypeRepository sponsorshipTypeRepository;

    public List<SponsorshipType> getAllSponsorshipType(){
        return sponsorshipTypeRepository.findAll();
    }

}
