package com.project.voting_system.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long electionID;
    private String date;
    private String type;

}
