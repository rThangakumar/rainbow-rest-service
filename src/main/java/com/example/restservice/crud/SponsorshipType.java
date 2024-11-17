package com.example.restservice.crud;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "SponsorshipType", schema = "dbo")
public class SponsorshipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SponsorshipTypeID")
    private Integer sponsorshipTypeID;

    @Column(name = "SponsorshipType")
    private String sponsorshipType;


    public void setSponsorshipTypeID(Integer sponsorshipTypeID) {
        this.sponsorshipTypeID = sponsorshipTypeID;
    }

    public void setSponsorshipType(String sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

}


