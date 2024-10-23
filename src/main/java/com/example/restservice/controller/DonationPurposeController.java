package com.example.restservice.controller;

import com.example.restservice.model.DonationPurposeRequest;
import com.example.restservice.model.DonationPurposeResponse;
import com.example.restservice.service.DonationPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DonationPurposeController {
    @Autowired
    private DonationPurposeService donationPurposeService;

    @PostMapping("/createDonationPurpose")
    public ResponseEntity<DonationPurposeResponse> createDonationPurpose(@RequestBody DonationPurposeRequest donationPurposeRequest) {
        DonationPurposeResponse savedDonationPurpose = donationPurposeService.addDonationPurpose(donationPurposeRequest);
        return new ResponseEntity<>(savedDonationPurpose, HttpStatus.CREATED);
    }
}
