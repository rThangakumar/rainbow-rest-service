package com.example.restservice.crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "StateNetwork", schema = "dbo")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateNetworkNo")
    private Short stateNetworkNo;

    @Column(name = "StateNetworkName")
    private String stateNetworkName;

    @Column(name = "StateNetworkCode")
    private String stateNetworkCode;

    @Column(name = "ContactPerson")
    private String contactPerson;

    @Column(name = "JobTitle")
    private Integer jobTitle;

    @Column(name = "PhoneNo")
    private String phoneNo;

    @Column(name = "MobileNo")
    private String mobileNo;

    @Column(name = "EmailID")
    private String emailID;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private Integer country;

    @Column(name = "State")
    private Integer state;

    @Column(name = "District")
    private Integer district;

    @Column(name = "Pincode")
    private String pincode;

    @Column(name = "RegionalNo")
    private Integer regionalNo;

    @Column(name = "CREATED_BY")
    private Integer createdBy;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "MODIFIED_BY")
    private Integer modifiedby;

    @Column(name = "MODIFIED_ON")
    private LocalDateTime modifiedOn;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "yearorder")
    private Integer yearOrder;

}
