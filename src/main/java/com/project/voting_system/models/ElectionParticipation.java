package com.project.voting_system.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ElectionParticipation {
    @EmbeddedId
    private ElectionParticipationKey id;

    @ManyToOne
    @MapsId("electionID")
    @JoinColumn(name = "electionID")
    private Election election;

    @ManyToOne
    @MapsId("partyID")
    @JoinColumn(name = "partyID")
    private PoliticalParty party;

    // Getters and Setters
}
