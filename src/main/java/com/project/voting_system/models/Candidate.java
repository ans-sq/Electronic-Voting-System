package com.project.voting_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateID;
    private String name;

    @ManyToOne
    @JoinColumn(name = "partyID")
    private PoliticalParty party;

    @ManyToOne
    @JoinColumn(name = "constituencyID")
    private Constituency constituency;

}

