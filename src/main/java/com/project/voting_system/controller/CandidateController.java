package com.project.voting_system.controller;

import com.project.voting_system.models.Candidate;
import com.project.voting_system.models.Constituency;
import com.project.voting_system.models.PoliticalParty;
import com.project.voting_system.requests.AddCandidateRequest;
import com.project.voting_system.services.CandidateService;
import com.project.voting_system.services.ConstituencyService;
import com.project.voting_system.services.PoliticalPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class CandidateController {

    private CandidateService candidateService;
    private PoliticalPartyService politicalPartyService;
    private ConstituencyService constituencyService;

    @Autowired
    public CandidateController(CandidateService candidateService,
                               PoliticalPartyService politicalPartyService,
                               ConstituencyService constituencyService) {
        this.candidateService = candidateService;
        this.politicalPartyService = politicalPartyService;
        this.constituencyService = constituencyService;
    }

    @GetMapping("/candidates")
    public ResponseEntity<?> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{partyId}/candidates")
    public ResponseEntity<?> getCandidatesByPartyId(@PathVariable Long partyId) {
        PoliticalParty p = politicalPartyService.getPoliticalPartyById(partyId);
        if (p == null) {
            return ResponseEntity.badRequest().body("Party not found");
        }
        return ResponseEntity.ok(candidateService.getCandidates(p));
    }

    @PostMapping("/{partyId}/{constituencyId}/candidate")
    public ResponseEntity<?> addCandidate(@PathVariable Long partyId, @PathVariable Long constituencyId,
                                          @RequestBody AddCandidateRequest addCandidateRequest) {
        PoliticalParty p = politicalPartyService.getPoliticalPartyById(partyId);
        if (p == null) {
            return ResponseEntity.badRequest().body("Party not found");
        }
        Constituency constituency = constituencyService.getConstituencyById(constituencyId);
        if (constituency == null) {
            return ResponseEntity.badRequest().body("Constituency not found");
        }

        Candidate candidate = new Candidate();
        candidate.setName(addCandidateRequest.getName());
        candidate.setConstituency(constituency);
        candidate.setParty(p);

        candidate = candidateService.createCandidate(candidate);

        return ResponseEntity.ok(candidate);
    }
}
