package com.example.restservice.service;

import com.example.restservice.crud.*;
import com.example.restservice.model.*;
import com.example.restservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.microsoft.sqlserver.jdbc.StringUtils.isNumeric;

@Service
public class LeadModuleService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private FollowUpRepository followUpRepository;

    @Autowired
    private LeadDonationRepository leadDonationRepository;

    @Autowired
    private LeadOrganisationTypeRepository leadOrganisationTypeRepository;

    @Autowired
    private FollowUpModeRepository followUpModeRepository;

    @Autowired
    private WillingToSupportCategoryRepository willingToSupportCategoryRepository;

    @Autowired
    private DonationReportTypeRepository donationReportTypeRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private StaffRepository staffRepository;


    public LeadResponse createLead(LeadRequest leadRequest) {
        Lead leadEntity = leadRepository.save(toLeadEntity(leadRequest));
        return toLeadResponse(leadEntity);
    }

    public List<Lead> getLeadListBySearchParams(String search) {
        if (isNumeric(search)){
            long phone = Long.parseLong(search);
            if ((phone%10^9)!=0){
                return leadRepository.findByOrgContactNumberAndConvertedToDonor(search, false);
            }
        }
        else {
            if(search.startsWith("Lead")){
                return leadRepository.findAllByLeadNoAndConvertedToDonor(search, false);
            }
        }
        return leadRepository.findByOrganisationNameAndConvertedToDonor(search, false);

    }

    public List<Lead> getConvertedLeadListBySearchParams(String search) {
        if (isNumeric(search)){
            long phone = Long.parseLong(search);
            if ((phone%10^9)!=0){
                return leadRepository.findByOrgContactNumberAndConvertedToDonor(search, true);
            }
        }
        else {
            if(search.startsWith("Lead")){
                return leadRepository.findAllByLeadNoAndConvertedToDonor(search, true);
            }
        }
        return leadRepository.findByOrganisationNameAndConvertedToDonor(search, true);

    }

    public FollowUpResponse addFollowUp(FollowUpRequest followUpRequest) {
        FollowUp followUpEntity = followUpRepository.save(toFollowUpEntity(followUpRequest));
        return toFollowUpResponse(followUpEntity);
    }

    public LeadDonationResponse addLeadDonation(LeadDonationRequest leadDonationRequest) {
        LeadDonation leadDonationEntity = leadDonationRepository.save(toLeadDonationEntity(leadDonationRequest));
        Lead leadEntity = leadRepository.findByLeadNo(leadDonationRequest.getLeadNo());
        if(leadEntity != null) {
            leadEntity.setConvertedToDonor(true);
            leadRepository.save(leadEntity);
        }
        return toLeadDonationResponse(leadDonationEntity);
    }

    public List<LeadOrganisationType> getAllLeadOrganisationType() {
        return leadOrganisationTypeRepository.findAll();
    }

    public List<WillingToSupportCategory> getAllWillingToSupportCategory() {
        return willingToSupportCategoryRepository.findAll();
    }

    public List<FollowUpMode> getAllFollowUpMode() {
        return followUpModeRepository.findAll();
    }


    public List<FollowUp> getFollowUpByLeadNo(String leadNo) {
        return followUpRepository.findByLeadNo(leadNo);
    }


    public List<DonationReportType> getAllDonationReportType() {
        return donationReportTypeRepository.findAll();
    }

    public List<AssignedToResponse> getAssignedToList(Integer userId) {
        UserInfo user = userInfoRepository.findByUserNo(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Integer orgId = user.getOrgId();

        // Fetch all staff with matching orgId and jobTitle == 1
        // Job title 1 is of Project In charge, hardcoding for now, can put conditions later based on orgLevel
        List<Staff> staffList = staffRepository.findByOrgIDAndJobTitle(orgId, 1);

        List<AssignedToResponse> assignedToList = new ArrayList<>();
        for(Staff staffMember : staffList) {
            String userName = staffMember.getFirstName() + " " + staffMember.getLastName();
            AssignedToResponse res = new AssignedToResponse();
            res.setUserId(staffMember.getStaffNo());
            res.setUserName(userName);
            assignedToList.add(res);
        }

        return  assignedToList;
    }

    private FollowUpResponse toFollowUpResponse(FollowUp followUpEntity) {
        FollowUpResponse followUpResponse = new FollowUpResponse();
        followUpResponse.setFollowUpId(followUpEntity.getFollowUpId());
        followUpResponse.setAssignedTo(followUpEntity.getAssignedTo());
        followUpResponse.setModeId(followUpEntity.getModeId());
        followUpResponse.setRemarks(followUpEntity.getRemarks());
        followUpResponse.setFollowUpDate(followUpEntity.getFollowUpDate());
        followUpResponse.setCreatedDate(followUpEntity.getCreatedDate());
        followUpResponse.setLeadNo(followUpEntity.getLeadNo());
        return followUpResponse;
    }

    private LeadDonation toLeadDonationEntity(LeadDonationRequest leadDonationRequest) {
        LeadDonation leadDonationEntity = LeadDonation.builder()
                .donationAmount(leadDonationRequest.getDonationAmount())
                .donationCycle(leadDonationRequest.getDonationCycle())
                .remarks(leadDonationRequest.getRemarks())
                .quarterlyReportTypeId(leadDonationRequest.getQuarterlyReportTypeId())
                .halfYearlyReportTypeId(leadDonationRequest.getHalfYearlyReportTypeId())
                .yearlyReportTypeId(leadDonationRequest.getYearlyReportTypeId())
                .shareReport(leadDonationRequest.getShareReport())
                .renewDonor(leadDonationRequest.getRenewDonor())
                .createdDate(LocalDateTime.now())
                .leadNo(leadDonationRequest.getLeadNo())
                .build();
        return leadDonationEntity;
    }

    private LeadDonationResponse toLeadDonationResponse(LeadDonation leadDonationEntity) {
        LeadDonationResponse leadDonationResponse = new LeadDonationResponse();
        leadDonationResponse.setLeadDonationId(leadDonationEntity.getLeadDonationId());
        leadDonationResponse.setDonationAmount(leadDonationEntity.getDonationAmount());
        leadDonationResponse.setDonationCycle(leadDonationEntity.getDonationCycle());
        leadDonationResponse.setRemarks(leadDonationEntity.getRemarks());
        leadDonationResponse.setQuarterlyReportTypeId(leadDonationEntity.getQuarterlyReportTypeId());
        leadDonationResponse.setHalfYearlyReportTypeId(leadDonationEntity.getHalfYearlyReportTypeId());
        leadDonationResponse.setYearlyReportTypeId(leadDonationEntity.getYearlyReportTypeId());
        leadDonationResponse.setShareReport(leadDonationEntity.getShareReport());
        leadDonationResponse.setRenewDonor(leadDonationEntity.getRenewDonor());
        leadDonationResponse.setCreatedDate(leadDonationEntity.getCreatedDate());
        leadDonationResponse.setLeadNo(leadDonationEntity.getLeadNo());
        return leadDonationResponse;
    }

    private FollowUp toFollowUpEntity(FollowUpRequest followUpRequest) {
        FollowUp followUpEntity = FollowUp.builder()
                .assignedTo(followUpRequest.getAssignedTo())
                .modeId(followUpRequest.getModeId())
                .remarks(followUpRequest.getRemarks())
                .followUpDate(followUpRequest.getFollowUpDate())
                .createdDate(LocalDateTime.now())
                .leadNo(followUpRequest.getLeadNo())
                .build();
        return followUpEntity;
    }

    private LeadResponse toLeadResponse(Lead leadEntity) {
        LeadResponse response = new LeadResponse();
        response.setLeadNo(leadEntity.getLeadNo());
        response.setOrganisationName(leadEntity.getOrganisationName());
        response.setLeadOrganisationTypeId(leadEntity.getLeadOrganisationTypeId());
        response.setOrganisationLogoName(leadEntity.getOrganisationLogoName());
        response.setOrganisationRegion(leadEntity.getOrganisationRegion());
        response.setAddress(leadEntity.getAddress());
        response.setOrgContactNumber(leadEntity.getOrgContactNumber());
        response.setPointOfContactName(leadEntity.getPointOfContactName());
        response.setGenderId(leadEntity.getGenderId());
        response.setDesignation(leadEntity.getDesignation());
        response.setEmail(leadEntity.getEmail());
        response.setPocContactNumber(leadEntity.getPocContactNumber());
        response.setWillingToSupport(leadEntity.getWillingToSupport());
        response.setExpectedAmount(leadEntity.getExpectedAmount());
        response.setUtilizationFrom(leadEntity.getUtilizationFrom());
        response.setUtilizationTo(leadEntity.getUtilizationTo());
        response.setProposalSubmitted(leadEntity.getProposalSubmitted());
        response.setLeadBroughtBy(leadEntity.getLeadBroughtBy());
        response.setFollowUp(leadEntity.getFollowUp());
        response.setCreatedDate(leadEntity.getCreatedDate());

        return response;
    }

    private Lead toLeadEntity(LeadRequest leadRequest) {
        // Generate a unique LeadNo like "Lead_randomNumber"
        String leadNo = "Lead_" + UUID.randomUUID().toString().substring(0, 6);

        Lead leadEntity = Lead.builder()
                .leadNo(leadNo)
                .organisationName(leadRequest.getOrganisationName())
                .leadOrganisationTypeId(leadRequest.getLeadOrganisationTypeId())
                .organisationLogoName(leadRequest.getOrganisationLogoName())
                .organisationRegion(leadRequest.getOrganisationRegion())
                .address(leadRequest.getAddress())
                .orgContactNumber(leadRequest.getOrgContactNumber())
                .pointOfContactName(leadRequest.getPointOfContactName())
                .genderId(leadRequest.getGenderId())
                .designation(leadRequest.getDesignation())
                .email(leadRequest.getEmail())
                .pocContactNumber(leadRequest.getPocContactNumber())
                .willingToSupport(leadRequest.getWillingToSupport())
                .expectedAmount(leadRequest.getExpectedAmount())
                .utilizationFrom(leadRequest.getUtilizationFrom())
                .utilizationTo(leadRequest.getUtilizationTo())
                .proposalSubmitted(leadRequest.getProposalSubmitted())
                .leadBroughtBy(leadRequest.getLeadBroughtBy())
                .followUp(leadRequest.getFollowUp())
                .createdDate(LocalDateTime.now())
                .convertedToDonor(false)
                .build();

        return leadEntity;
    }
}
