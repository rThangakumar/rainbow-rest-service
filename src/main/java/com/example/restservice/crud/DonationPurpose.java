package com.example.restservice.crud;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DonationPurpose")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationPurpose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "purpose_name", nullable = false)
    private String purposeName;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn = LocalDateTime.now();

    @Column(name = "created_by")
    private Integer createdBy;

}

