package com.example.restservice.service;


import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Inkind;
import com.example.restservice.repository.DonorTypeRepository;
import com.example.restservice.repository.InkindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InkindService {

    @Autowired
    private InkindRepository inkindRepository;

    public List<Inkind> getAllInkindList(){
        return inkindRepository.findAll();
    }

}
