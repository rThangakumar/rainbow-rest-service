package com.example.restservice.service;
import com.example.restservice.crud.DonationReason;
import com.example.restservice.repository.DonationReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DonationReasonService {

    @Autowired
    private DonationReasonRepository donationReasonRepository;

    public List<DonationReason> getAllDonationReason(){
        return donationReasonRepository.findAll();
    }



}
