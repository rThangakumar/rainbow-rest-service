package com.example.restservice.service;

import com.example.restservice.crud.Gender;
import com.example.restservice.crud.Inkind;
import com.example.restservice.repository.GenderRepository;
import com.example.restservice.repository.InkindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {


    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> getAllGenderList(){
        return genderRepository.findAll();
    }

}

