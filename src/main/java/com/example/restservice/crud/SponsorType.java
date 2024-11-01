package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "SponsorType")
public class SponsorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SponsorTypeID")
    private Integer sponsorTypeID;

    @Column(name = "SponsorType")
    private String sponsorType;


    public Integer getSponsorTypeID() {
        return sponsorTypeID;
    }

    public void setSponsorTypeID(Integer sponsorTypeID) {
        this.sponsorTypeID = sponsorTypeID;
    }

    public String getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType;
    }
}


