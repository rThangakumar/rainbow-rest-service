package com.example.restservice.service;

import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Sponsor;
import com.example.restservice.model.SponsorRequest;
import com.example.restservice.model.SponsorResponse;
import com.example.restservice.repository.DonorTypeRepository;
import com.example.restservice.repository.SponsorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Autowired
    private DonorTypeRepository donorTypeRepository;

    private static final Logger logger = LoggerFactory.getLogger(SponsorService.class);

    @Transactional
    public SponsorResponse createSponsor(SponsorRequest sponsorRequest) {
        try {
            DonorType donorType = donorTypeRepository.findById(sponsorRequest.getDonorTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Donor Type Id"));

            Sponsor sponsorEntity = toSponsorEntity(sponsorRequest, donorType);

            Sponsor savedSponsor = sponsorRepository.save(sponsorEntity);

            return toSponsorResponse(savedSponsor);
        } catch (IllegalArgumentException ex) {
            logger.error("Invalid Donor Type Id", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
             logger.error("Unexpected error occurred while creating Sponsor", ex);
            throw new RuntimeException("An error occurred while creating the sponsor. Please try again later.", ex);
        }
    }

    private Sponsor toSponsorEntity(SponsorRequest sponsorRequest, DonorType donorType) {
        return Sponsor.builder()
                .sponsorName(sponsorRequest.getSponsorName())
                .rhNo(sponsorRequest.getRhNo())
                .panNumber(sponsorRequest.getPanNumber())
                .mobileNo(sponsorRequest.getMobileNo())
                .emailId(sponsorRequest.getEmailId())
                .donorType(donorType)
                .createdOn(LocalDateTime.now())
                .createdBy(sponsorRequest.getCreatedBy())
                .modifiedOn(LocalDateTime.now())
                .modifiedBy(sponsorRequest.getModifiedBy())
                .birthday(sponsorRequest.getBirthday())
                .address(sponsorRequest.getAddress())
                .build();
    }

    private SponsorResponse toSponsorResponse(Sponsor savedSponsor) {
        return SponsorResponse.builder()
                .sponsorId(savedSponsor.getSponsorNo())
                .sponsorName(savedSponsor.getSponsorName())
                .rhNo(savedSponsor.getRhNo())
                .panNumber(savedSponsor.getPanNumber())
                .modifiedOn(savedSponsor.getModifiedOn())
                .modifiedBy(savedSponsor.getModifiedBy())
                .mobileNo(savedSponsor.getMobileNo())
                .emailId(savedSponsor.getEmailId())
                .donorTypeName(savedSponsor.getDonorType().getDonorTypeName())
                .createdOn(savedSponsor.getCreatedOn())
                .createdBy(savedSponsor.getCreatedBy())
                .birthday(savedSponsor.getBirthday())
                .address(savedSponsor.getAddress())
                .build();
    }

    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public List<Sponsor> getSponsorListBySearchParams(String search){
        if (isNumeric(search)){
            long phone = Long.parseLong(search);
            if ((phone%10^9)!=0){
                return sponsorRepository.findByMobileNo(search);
            }
//            return sponsorRepository.findBySponsorNoStartingWith(Integer.parseInt(search));
            return sponsorRepository.findAllById(Collections.singleton(Integer.parseInt(search)));
        }
        else {
            return sponsorRepository.findBySponsorNameStartingWith(search);
        }
    }
}
