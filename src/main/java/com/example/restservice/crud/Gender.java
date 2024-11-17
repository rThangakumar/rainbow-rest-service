package com.example.restservice.crud;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Gender")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gender {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GenderID", nullable = false)
    private Integer genderID;

    @Column(name = "Gender", nullable = false, length = 255)
    private String gender;


}
