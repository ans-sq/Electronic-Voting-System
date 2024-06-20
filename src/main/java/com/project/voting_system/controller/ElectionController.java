package com.project.voting_system.controller;

import com.project.voting_system.models.Election;
import com.project.voting_system.requests.AddElectionRequest;
import com.project.voting_system.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evs")
public class ElectionController {

    private ElectionService electionService;

    @Autowired
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @GetMapping("/elections")
    public ResponseEntity<?> getAllElections() {
        return ResponseEntity.ok(electionService.getAllElections());
    }

    @GetMapping("/elections/{type}")
    public ResponseEntity<?> getElectionsByType(@PathVariable String type) {
        return ResponseEntity.ok(electionService.getElectionsByType(type));
    }

    @PostMapping("/election")
    public ResponseEntity<?> addElection(@RequestBody AddElectionRequest addElectionRequest) {
        if (electionService.electionsExists(addElectionRequest.getDate(), addElectionRequest.getType())) {
            return ResponseEntity.badRequest().body("Election already exists");
        }

        Election election = new Election();
        election.setDate(addElectionRequest.getDate());
        election.setType(addElectionRequest.getType());

        election = electionService.createElection(election);

        return ResponseEntity.ok(election);
    }
}
