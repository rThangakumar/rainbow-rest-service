package com.example.restservice.crud;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sponsor", schema = "dbo")
@Builder
@Data
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SponsorNo")
    private Integer sponsorNo;

    @Column(name = "SponsorName", length = 250, nullable = true)
    private String sponsorName;

    @Column(name = "Created_On", nullable = true)
    private LocalDateTime createdOn;

    @Column(name = "Created_By", nullable = true)
    private Integer createdBy;

    @Column(name = "Modified_By", nullable = true)
    private Integer modifiedBy;

    @Column(name = "Modified_On", nullable = true)
    private LocalDateTime modifiedOn;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "RHNo", nullable = true)
//    private RainbowHome rainbowHome;

    @Column(name = "RHNo", nullable = true)
    private Integer rhNo;

    @Column(name = "mobileno", length = 15, nullable = true)
    private String mobileNo;

    @Column(name = "emailid", length = 50, nullable = true)
    private String emailId;

    @Column(name = "Addres", length = 100, nullable = true)
    private String address;

    @Column(name = "Birthday", nullable = true)
    private LocalDateTime birthday;

    @Column(name = "Pan_Number", nullable = true)
    private String panNumber;
//
//    @Column(name = "donorTypeId", nullable = true)
//    private Integer donorTypeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "donorTypeId", nullable = false)
    private DonorType donorType;

}

