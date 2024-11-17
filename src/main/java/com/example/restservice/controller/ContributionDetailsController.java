package com.example.restservice.controller;

import com.example.restservice.NotificationService;
import com.example.restservice.model.ContributionRequest;
import com.example.restservice.model.ContributionResponse;
import com.example.restservice.service.ContributionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContributionDetailsController {

    @Autowired
    private ContributionDetailsService contributionDetailsService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/createContribution")
    public ResponseEntity<List<ContributionResponse>> createContribution(@RequestBody ContributionRequest contributionRequest) {
        List<ContributionResponse> savedContributionList = contributionDetailsService.createContribution(contributionRequest);
        notificationService.sendNewDonationNotification(savedContributionList);
        return new ResponseEntity<>(savedContributionList, HttpStatus.CREATED);
    }
}
