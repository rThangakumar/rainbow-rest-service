package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class SponsorResponse {

    @JsonProperty("sponsorId")
    private Integer sponsorId;

    @JsonProperty("sponsorName")
    private String sponsorName;

    @JsonProperty("rhNo")
    private Integer rhNo;

    @JsonProperty("panNumber")
    private String panNumber;

    @JsonProperty("modifiedOn")
    private LocalDateTime modifiedOn;

    @JsonProperty("modifiedBy")
    private Integer modifiedBy;

    @JsonProperty("mobileNo")
    private String mobileNo;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("donorTypeName")
    private String donorTypeName;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("createdBy")
    private Integer createdBy;

    @JsonProperty("birthday")
    private LocalDateTime birthday;

    @JsonProperty("address")
    private String address;
}


