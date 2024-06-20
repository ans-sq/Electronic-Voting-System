package com.project.voting_system.controller;

import com.project.voting_system.models.PoliticalParty;
import com.project.voting_system.requests.AddPoliticalPartyRequest;
import com.project.voting_system.services.PoliticalPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evs")
public class PoliticalPartyController {

    private final PoliticalPartyService politicalPartyService;

    @Autowired
    public PoliticalPartyController(PoliticalPartyService politicalPartyService) {
        this.politicalPartyService = politicalPartyService;
    }

    @GetMapping("/parties")
    public ResponseEntity<?> getAllPoliticalParties() {
        return ResponseEntity.ok(politicalPartyService.getAllPoliticalParties());
    }

    @PostMapping("/party")
    public ResponseEntity<?> addPoliticalParty(@RequestBody AddPoliticalPartyRequest addPoliticalPartyRequest) {
        if (politicalPartyService.getPoliticalPartyByName(addPoliticalPartyRequest.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("Political party already exists");
        }

        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName(addPoliticalPartyRequest.getName());
        politicalParty = politicalPartyService.createPoliticalParty(politicalParty);

        return ResponseEntity.ok(politicalParty);
    }
}
