package com.example.restservice.service;


import com.example.restservice.crud.ContributionDetails;
import com.example.restservice.model.ContributionRequest;
import com.example.restservice.model.ContributionResponse;
import com.example.restservice.repository.ContributionDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContributionDetailsService {

    @Autowired
    private ContributionDetailsRepository contributionDetailsRepository;

    private static final Logger logger = LoggerFactory.getLogger(ContributionDetailsService.class);

    @Transactional
    public List<ContributionResponse> createContribution(ContributionRequest contributionRequest) {
        try {
            Integer[] rhNos = contributionRequest.getRHNos();
            int numberOfRhs = rhNos.length;

            double dividedAmount = contributionRequest.getAmount() / numberOfRhs;
            int dividedQuantity = contributionRequest.getQuantity() / numberOfRhs;
            double budgetedDonation = contributionRequest.getBudgetedFromDonation() / numberOfRhs;
            double unBudgetedDonation = contributionRequest.getUnBudgetedFromDonation() / numberOfRhs;

            ContributionDetails savedContributionEntity = null;
            List<ContributionResponse> contributionResponseList = new ArrayList<>();

            for (Integer rhNo : rhNos) {
                ContributionDetails requestEntity = toRequestEntity(contributionRequest);
                requestEntity.setRhNo(rhNo);
                requestEntity.setAmount(dividedAmount);
                requestEntity.setQuantity(dividedQuantity);
                requestEntity.setBudgetedFromDonation(budgetedDonation);
                requestEntity.setUnBudgetedFromDonation(unBudgetedDonation);

                savedContributionEntity = contributionDetailsRepository.save(requestEntity);

                contributionResponseList.add(toContributionResponse(savedContributionEntity));
            }

            return contributionResponseList;
        } catch (Exception ex) {
            logger.error("Error occurred while creating contribution", ex);

            throw new RuntimeException("Error occurred while creating contribution", ex);
        }

    }

    private ContributionDetails toRequestEntity(ContributionRequest contributionRequest) {
        return ContributionDetails.builder()
                .sponsorshipTypeId(contributionRequest.getSponsorshipTypeID())
                .sponsorName(contributionRequest.getSponsorName())
                .contributionDate(contributionRequest.getContributionDate())
                .inkindID(contributionRequest.getInkindId())
                .createdOn(contributionRequest.getCreatedOn())
                .createdBy(contributionRequest.getCreatedBy())
                .modifiedBy(contributionRequest.getModifiedBy())
                .modifiedOn(contributionRequest.getModifiedOn())
                .status(true)
                .donationReasonId(contributionRequest.getDonationReasonId())
                .donationOccasion(contributionRequest.getDonationOccasion())
                .programTypeId(contributionRequest.getProgramTypeId())
                .donorPreferenceId(contributionRequest.getDonorPreferenceId())
                .sponsorId(contributionRequest.getSponsorId())
                .budgetedFromDonation(contributionRequest.getBudgetedFromDonation())
                .unBudgetedFromDonation(contributionRequest.getUnBudgetedFromDonation())
                .specialDayDate(contributionRequest.getSpecialDayDate())
                .donationPurposeId(contributionRequest.getDonationPurposeId())
                .build();
    }

    private ContributionResponse toContributionResponse(ContributionDetails savedContributionEntity) {
        return ContributionResponse.builder()
                .contributionId(savedContributionEntity.getContributionNo())
                .rhNo(savedContributionEntity.getRhNo())
                .sponsorshipTypeID(savedContributionEntity.getSponsorshipTypeId())
                .sponsorName(savedContributionEntity.getSponsorName())
                .contributionDate(savedContributionEntity.getContributionDate())
                .inkindId(savedContributionEntity.getInkindID())
                .quantity(savedContributionEntity.getQuantity())
                .amount(savedContributionEntity.getAmount())
                .createdOn(savedContributionEntity.getCreatedOn())
                .createdBy(savedContributionEntity.getCreatedBy())
                .modifiedBy(savedContributionEntity.getModifiedBy())
                .modifiedOn(savedContributionEntity.getModifiedOn())
                .donationReasonId(savedContributionEntity.getDonationReasonId())
                .donationOccasion(savedContributionEntity.getDonationOccasion())
                .programTypeId(savedContributionEntity.getProgramTypeId())
                .donorPreferenceId(savedContributionEntity.getDonorPreferenceId())
                .sponsorId(savedContributionEntity.getSponsorId())
                .status(savedContributionEntity.getStatus())
                .budgetedFromDonation(savedContributionEntity.getBudgetedFromDonation())
                .unBudgetedFromDonation(savedContributionEntity.getUnBudgetedFromDonation())
                .specialDayDate(savedContributionEntity.getSpecialDayDate())
                .donationPurposeId(savedContributionEntity.getDonationPurposeId())
                .build();
    }
}
