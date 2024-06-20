package com.project.voting_system.requests;

import lombok.Data;

@Data
public class AddElectionRequest {
    private String date;
    private String type;
}
