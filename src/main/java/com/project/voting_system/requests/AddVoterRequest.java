package com.project.voting_system.requests;

import lombok.Data;

@Data
public class AddVoterRequest {
    private String name;
    private String cnic;
    private String dob;
}
