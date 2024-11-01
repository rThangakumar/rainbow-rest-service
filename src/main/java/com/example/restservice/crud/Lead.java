package com.example.restservice.crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "Lead")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lead {

    @Id
    @Column(name = "LeadNo", nullable = false, unique = true, length = 50)
    private String leadNo;

    @Column(name = "OrganisationName", nullable = false, length = 255)
    private String organisationName;

    @Column(name = "LeadOrganisationTypeId", nullable = false)
    private Integer leadOrganisationTypeId; // Foreign Key

    @Column(name = "OrganisationLogoName")
    private String organisationLogoName;

    @Column(name = "OrganisationRegion", nullable = false, length = 20)
    private String organisationRegion;

    @Column(name = "Address", nullable = false, length = 500)
    private String address;

    @Column(name = "OrgContactNumber", length = 15)
    private String orgContactNumber;

    @Column(name = "PointOfContactName", length = 255)
    private String pointOfContactName;

    @Column(name = "GenderId", nullable = false)
    private Integer genderId; // Foreign Key to Gender table

    @Column(name = "Designation", length = 255)
    private String designation;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "PocContactNumber", length = 15)
    private String pocContactNumber;

    @Column(name = "WillingToSupport", nullable = false, length = 255)
    private String willingToSupport;

    @Column(name = "ExpectedAmount", precision = 18, scale = 2)
    private Double expectedAmount;

    @Column(name = "UtilizationFrom", nullable = false)
    private LocalDate utilizationFrom;

    @Column(name = "UtilizationTo", nullable = false)
    private LocalDate utilizationTo;

    @Column(name = "ProposalSubmitted", nullable = false)
    private Boolean proposalSubmitted;

    @Column(name = "LeadBroughtBy", nullable = false, length = 255)
    private String leadBroughtBy;

    @Column(name = "FollowUp", nullable = false)
    private Boolean followUp;

    @Column(name = "CreatedDate", nullable = false)
    private LocalDateTime createdDate;
}

