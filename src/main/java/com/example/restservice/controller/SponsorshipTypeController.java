package com.example.restservice.controller;
import com.example.restservice.crud.SponsorshipType;
import com.example.restservice.service.SponsorshipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class SponsorshipTypeController {

    @Autowired
    private SponsorshipTypeService sponsorshipTypeService;

    @GetMapping("/paymentMode")
    public ResponseEntity<List<SponsorshipType>> getPaymentMode(){
        List<SponsorshipType> sponsorshipType = sponsorshipTypeService.getAllSponsorshipType();
        return ResponseEntity.ok(sponsorshipType);
    }
}