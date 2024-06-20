package com.project.voting_system.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vote {
    @EmbeddedId
    private VoteKey id;

    @ManyToOne
    @MapsId("voterID")
    @JoinColumn(name = "voterID")
    private Voter voter;

    @ManyToOne
    @MapsId("electionID")
    @JoinColumn(name = "electionID")
    private Election election;

    @ManyToOne
    @MapsId("candidateID")
    @JoinColumn(name = "candidateID")
    private Candidate candidate;

    // Getters and Setters
}

