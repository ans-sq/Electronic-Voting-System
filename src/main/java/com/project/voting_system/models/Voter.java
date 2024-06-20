package com.project.voting_system.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterID;
    private String name;
    @Column(unique = true)
    private String cnic;
    private String dob;

    @ManyToOne
    @JoinColumn(name = "addressID")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "areaID")
    private RegistrationArea area;

}

