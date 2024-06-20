package com.project.voting_system.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class VoteKey implements Serializable {
    private Long voterID;
    private Long electionID;
    private Long candidateID;
}
