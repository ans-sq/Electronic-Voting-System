package com.project.voting_system.requests;

import lombok.Data;

@Data
public class AddAddressRequest {
    private String street;
    private String city;
    private String province;
    private String country;
    private String postalCode;
}
