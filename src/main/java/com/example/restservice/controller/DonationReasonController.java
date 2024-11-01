package com.example.restservice.controller;

import com.example.restservice.crud.DonationReason;
import com.example.restservice.service.DonationReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DonationReasonController {

    @Autowired
    private DonationReasonService donationReasonService;

    @GetMapping("/donationReason")
    public ResponseEntity<List<DonationReason>> getAllDonationReason(){
        List<DonationReason> donationReasons = donationReasonService.getAllDonationReason();
        return ResponseEntity.ok(donationReasons);
    }

}
