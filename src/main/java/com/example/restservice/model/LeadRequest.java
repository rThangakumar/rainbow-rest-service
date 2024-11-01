package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LeadRequest {

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("utilizationFrom")
    private LocalDate utilizationFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("utilizationTo")
    private LocalDate utilizationTo;

    @JsonProperty("proposalSubmitted")
    private Boolean proposalSubmitted;

    @JsonProperty("leadBroughtBy")
    private String leadBroughtBy;

    @JsonProperty("followUp")
    private Boolean followUp;
}

