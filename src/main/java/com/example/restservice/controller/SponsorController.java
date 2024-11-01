package com.example.restservice.controller;

import com.example.restservice.crud.Sponsor;
import com.example.restservice.model.SponsorRequest;
import com.example.restservice.model.SponsorResponse;
import com.example.restservice.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sponsors")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @PostMapping("/createSponsor")
    public ResponseEntity<SponsorResponse> createSponsor(@RequestBody SponsorRequest sponsorRequest) {
        SponsorResponse newSponsor = sponsorService.createSponsor(sponsorRequest);
        return ResponseEntity.ok(newSponsor);
    }

    @GetMapping("/donor")
    public ResponseEntity<List<Sponsor>> searchSponsor(@RequestParam("search") String search) {
        List<Sponsor> sponsorList = sponsorService.getSponsorListBySearchParams(search);
        return ResponseEntity.ok(sponsorList);
    }

}