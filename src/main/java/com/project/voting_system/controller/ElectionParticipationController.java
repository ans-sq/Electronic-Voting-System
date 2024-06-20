package com.project.voting_system.controller;

import com.project.voting_system.models.Election;
import com.project.voting_system.models.ElectionParticipation;
import com.project.voting_system.models.ElectionParticipationKey;
import com.project.voting_system.models.PoliticalParty;
import com.project.voting_system.services.ElectionParticipationService;
import com.project.voting_system.services.ElectionService;
import com.project.voting_system.services.PoliticalPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evs")
public class ElectionParticipationController {

    private final ElectionParticipationService electionParticipationService;
    private final ElectionService electionService;
    private final PoliticalPartyService politicalPartyService;

    @Autowired
    public ElectionParticipationController(ElectionParticipationService electionParticipationService,
                                           ElectionService electionService,
                                           PoliticalPartyService politicalPartyService) {
        this.electionParticipationService = electionParticipationService;
        this.electionService = electionService;
        this.politicalPartyService = politicalPartyService;
    }

    @GetMapping("/electionParticipation")
    public ResponseEntity<?> electionParticipation() {
        return ResponseEntity.ok(electionParticipationService.getAllElectionParticipations());
    }

    @PostMapping("electionParticipation/{electionId}/{partyId}")
    public ResponseEntity<?> electionParticipation(@PathVariable Long electionId, @PathVariable Long partyId) {
        Election election = electionService.getElectionById(electionId);
        if (election == null) {
            return ResponseEntity.badRequest().body("Election not found");
        }
        PoliticalParty p = politicalPartyService.getPoliticalPartyById(partyId);
        if (p == null) {
            return ResponseEntity.badRequest().body("Political party not found");
        }
        ElectionParticipationKey key = new ElectionParticipationKey();
        key.setElectionID(electionId);
        key.setPartyID(partyId);
        ElectionParticipation participation = new ElectionParticipation();
        participation.setId(key);
        participation.setElection(election);
        participation.setParty(p);

        participation = electionParticipationService.createElectionParticipation(participation);

        return ResponseEntity.ok(participation);
    }
}
