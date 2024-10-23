package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SponsorRequest {

    @JsonProperty("sponsorName")
    private String sponsorName;

    @JsonProperty("rhNo")
    private Integer rhNo;

    @JsonProperty("panNumber")
    private String panNumber;

    @JsonProperty("mobileNo")
    private String mobileNo;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("donorTypeId")
    private Integer donorTypeId;

    @JsonProperty("createdBy")
    private Integer createdBy;

    @JsonProperty("modifiedBy")
    private Integer modifiedBy;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("modifiedOn")
    private LocalDateTime modifiedOn;

    @JsonProperty("birthday")
    private LocalDateTime birthday;

    @JsonProperty("address")
    private String address;

//    // Getters and Setters
//    public String getSponsorName() {
//        return sponsorName;
//    }
//
//    public void setSponsorName(String sponsorName) {
//        this.sponsorName = sponsorName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public LocalDateTime getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDateTime birthday) {
//        this.birthday = birthday;
//    }
//
//    public LocalDateTime getModifiedOn() {
//        return modifiedOn;
//    }
//
//    public void setModifiedOn(LocalDateTime modifiedOn) {
//        this.modifiedOn = modifiedOn;
//    }
//
//    public LocalDateTime getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(LocalDateTime createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public Integer getModifiedBy() {
//        return modifiedBy;
//    }
//
//    public void setModifiedBy(Integer modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//
//    public Integer getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Integer createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getEmailId() {
//        return emailId;
//    }
//
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public Integer getDonorTypeId() {
//        return donorTypeId;
//    }
//
//    public void setDonorTypeId(Integer donorTypeId) {
//        this.donorTypeId = donorTypeId;
//    }
//
//    public String getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    public String getPanNumber() {
//        return panNumber;
//    }
//
//    public void setPanNumber(String panNumber) {
//        this.panNumber = panNumber;
//    }
//
//    public String getRhNo() {
//        return rhNo;
//    }
//
//    public void setRhNo(String rhNo) {
//        this.rhNo = rhNo;
//    }
}

