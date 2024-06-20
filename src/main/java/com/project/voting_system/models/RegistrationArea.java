package com.project.voting_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RegistrationArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaID;
    private String name;

    @ManyToOne
    @JoinColumn(name = "constituencyID")
    private Constituency constituency;

}

