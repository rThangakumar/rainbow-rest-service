package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "SponsorshipType", schema = "dbo")
public class SponsorshipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SponsorshipTypeID")
    private Integer sponsorshipTypeID;

    @Column(name = "SponsorshipType")
    private String sponsorshipType;


    public Integer getSponsorshipTypeID() {
        return sponsorshipTypeID;
    }

    public void setSponsorshipTypeID(Integer sponsorshipTypeID) {
        this.sponsorshipTypeID = sponsorshipTypeID;
    }

    public String getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(String sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

}


