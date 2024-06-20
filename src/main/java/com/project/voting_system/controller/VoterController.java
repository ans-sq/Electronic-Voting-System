package com.project.voting_system.controller;

import com.project.voting_system.models.Address;
import com.project.voting_system.models.RegistrationArea;
import com.project.voting_system.models.Voter;
import com.project.voting_system.requests.AddVoterRequest;
import com.project.voting_system.services.AddressService;
import com.project.voting_system.services.RegistrationAreaService;
import com.project.voting_system.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class VoterController {

    private final VoterService voterService;
    private final AddressService addressService;
    private final RegistrationAreaService registrationAreaService;

    @Autowired
    public VoterController(VoterService voterService, AddressService addressService,
                           RegistrationAreaService registrationAreaService) {
        this.voterService = voterService;
        this.addressService = addressService;
        this.registrationAreaService = registrationAreaService;
    }

    @GetMapping("/voters")
    public ResponseEntity<?> getAllVoters() {
        return ResponseEntity.ok(voterService.getAllVoters());
    }

    @PostMapping("/voter/{registrationId}/{addressId}")
    public ResponseEntity<?> addVoter(@PathVariable Long registrationId, @PathVariable Long addressId,
                                      @RequestBody AddVoterRequest addVoterRequest) {
        RegistrationArea registrationArea = registrationAreaService.getRegistrationAreaById(registrationId);
        if (registrationArea == null) {
            return ResponseEntity.badRequest().body("Registration area not found");
        }
        Address address = addressService.getAddressById(addressId);
        if (address == null) {
            return ResponseEntity.badRequest().body("Address not found");
        }
        Voter voter = voterService.getVoterByCnic(addVoterRequest.getCnic());
        if (voter == null) {
            voter = new Voter();
        } else {
            return ResponseEntity.badRequest().body("Voter with cnic already exists");
        }
        voter.setAddress(address);
        voter.setArea(registrationArea);
        voter.setCnic(addVoterRequest.getCnic());
        voter.setName(addVoterRequest.getName());
        voter.setDob(addVoterRequest.getDob());

        voter = voterService.createVoter(voter);

        return ResponseEntity.ok(voter);
    }
}
