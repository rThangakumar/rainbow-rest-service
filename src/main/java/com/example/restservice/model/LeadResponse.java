package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeadResponse {

    @JsonProperty("leadNo")
    private String leadNo;

    @JsonProperty("organisationName")
    private String organisationName;

    @JsonProperty("leadOrganisationTypeId")
    private Integer leadOrganisationTypeId;

    @JsonProperty("organisationLogoName")
    private String organisationLogoName;

    @JsonProperty("organisationRegion")
    private String organisationRegion;

    @JsonProperty("address")
    private String address;

    @JsonProperty("orgContactNumber")
    private String orgContactNumber;

    @JsonProperty("pointOfContactName")
    private String pointOfContactName;

    @JsonProperty("genderId")
    private Integer genderId;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("email")
    private String email;

    @JsonProperty("pocContactNumber")
    private String pocContactNumber;

    @JsonProperty("willingToSupport")
    private String willingToSupport;

    @JsonProperty("expectedAmount")
    private Double expectedAmount;

    @JsonProperty("utilizationFrom")
    private LocalDate utilizationFrom;

    @JsonProperty("utilizationTo")
    private LocalDate utilizationTo;

    @JsonProperty("proposalSubmitted")
    private Boolean proposalSubmitted;

    @JsonProperty("leadBroughtBy")
    private String leadBroughtBy;

    @JsonProperty("followUp")
    private Boolean followUp;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;
}

