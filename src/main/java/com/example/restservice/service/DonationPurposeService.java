package com.example.restservice.service;

import com.example.restservice.crud.DonationPurpose;
import com.example.restservice.model.DonationPurposeRequest;
import com.example.restservice.model.DonationPurposeResponse;
import com.example.restservice.repository.DonationPurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DonationPurposeService {
    @Autowired
    private DonationPurposeRepository donationPurposeRepository;

    @Transactional
    public DonationPurposeResponse addDonationPurpose(DonationPurposeRequest donationPurposeRequest) {
        DonationPurpose savedDonationPurposeEntity = donationPurposeRepository.save(toRequestEntity(donationPurposeRequest));
        return toResponse(savedDonationPurposeEntity);
    }

    private DonationPurpose toRequestEntity(DonationPurposeRequest donationPurposeRequest) {
        return DonationPurpose.builder()
                .purposeName(donationPurposeRequest.getPurposeName())
                .isDefault(donationPurposeRequest.getIsDefault())
                .createdBy(donationPurposeRequest.getCreatedBy())
                .createdOn(LocalDateTime.now())
                .build();
    }

    private DonationPurposeResponse toResponse(DonationPurpose savedDonationPurposeEntity) {
        return DonationPurposeResponse.builder()
                .id(savedDonationPurposeEntity.getId())
                .purposeName(savedDonationPurposeEntity.getPurposeName())
                .isDefault(savedDonationPurposeEntity.getIsDefault())
                .createdBy(savedDonationPurposeEntity.getCreatedBy())
                .createdOn(savedDonationPurposeEntity.getCreatedOn())
                .build();
    }
}
