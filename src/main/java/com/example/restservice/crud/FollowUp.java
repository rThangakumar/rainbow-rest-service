package com.example.restservice.crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "FollowUp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FollowUpId", nullable = false)
    private Integer followUpId;

    @Column(name = "AssignedTo", nullable = false)
    private Integer assignedTo;

    @Column(name = "ModeId",  nullable = false)
    private Integer modeId;

    @Column(name = "Remarks", length = 500)
    private String remarks;

    @Column(name = "FollowUpDate", nullable = false)
    private LocalDate followUpDate;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "LeadNo", nullable = false, unique = true, length = 50)
    private String leadNo;
}
