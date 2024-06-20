package com.project.voting_system.models;


import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ElectionParticipationKey implements Serializable {
    private Long electionID;
    private Long partyID;
}
