package com.example.restservice.controller;

import com.example.restservice.crud.*;
import com.example.restservice.model.*;
import com.example.restservice.service.LeadModuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LeadModuleController {
    @Autowired
    private LeadModuleService leadModuleService;

    @PostMapping(value = "/create-lead")
    public ResponseEntity<LeadResponse> createLead(@RequestBody LeadRequest leadRequest) {
        LeadResponse leadResponse = leadModuleService.createLead(leadRequest);

        // Return the actual leadResponse object
        return ResponseEntity.ok(leadResponse);
    }

    @PostMapping("/add-followup")
    public ResponseEntity<FollowUpResponse> addFollowUp(@RequestBody FollowUpRequest followUpRequest) {
        FollowUpResponse followUpResponse = leadModuleService.addFollowUp(followUpRequest);
        return ResponseEntity.ok(followUpResponse);
    }

    @PostMapping("/add-lead-donation")
    public ResponseEntity<LeadDonationResponse> addLeadDonation(@RequestBody LeadDonationRequest leadDonationRequest) {
        LeadDonationResponse leadDonationResponse = leadModuleService.addLeadDonation(leadDonationRequest);
        return ResponseEntity.ok(leadDonationResponse);
    }

    @GetMapping("/lead-organisation-type")
    public ResponseEntity<List<LeadOrganisationType>> getAllProgramType(){
        List<LeadOrganisationType> leadOrganisationTypes = leadModuleService.getAllLeadOrganisationType();
        return ResponseEntity.ok(leadOrganisationTypes);
    }

    @GetMapping("/willing-to-support-category")
    public ResponseEntity<List<WillingToSupportCategory>> getAllWillingToSupportCategory(){
        List<WillingToSupportCategory> willingToSupportCategories = leadModuleService.getAllWillingToSupportCategory();
        return ResponseEntity.ok(willingToSupportCategories);
    }

    @GetMapping("/follow-up-mode")
    public ResponseEntity<List<FollowUpMode>> getAllFollowUpMode(){
        List<FollowUpMode> followUpModes = leadModuleService.getAllFollowUpMode();
        return ResponseEntity.ok(followUpModes);
    }

    @GetMapping("/donation-report-type")
    public ResponseEntity<List<DonationReportType>> getAllDonationReportType(){
        List<DonationReportType> donationReportTypes = leadModuleService.getAllDonationReportType();
        return ResponseEntity.ok(donationReportTypes);
    }


    @GetMapping("/get-lead")
    public ResponseEntity<List<Lead>> searchLeads(@RequestParam("search") String search) {
        List<Lead> leadList = leadModuleService.getLeadListBySearchParams(search);
        return ResponseEntity.ok(leadList);
    }

    @GetMapping("/get-converted-lead")
    public ResponseEntity<List<Lead>> searchConvertedLeads(@RequestParam("search") String search) {
        List<Lead> leadList = leadModuleService.getConvertedLeadListBySearchParams(search);
        return ResponseEntity.ok(leadList);
    }


    @GetMapping("/get-follow-up/{leadNo}")
    public ResponseEntity<List<FollowUp>> getFollowUpByLeadNo(@PathVariable String leadNo){
        List<FollowUp> followUps = leadModuleService.getFollowUpByLeadNo(leadNo);
        return ResponseEntity.ok(followUps);
    }

    @GetMapping("/get-assigned-to/{userId}")
    public ResponseEntity<List<AssignedToResponse>> getAssignedTo(@PathVariable Integer userId) {
        List<AssignedToResponse> assignedToList = leadModuleService.getAssignedToList(userId);
        return ResponseEntity.ok(assignedToList);
    }

}
