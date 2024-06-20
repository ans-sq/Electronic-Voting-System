package com.project.voting_system.controller;

import com.project.voting_system.models.*;
import com.project.voting_system.services.CandidateService;
import com.project.voting_system.services.ElectionService;
import com.project.voting_system.services.VoteService;
import com.project.voting_system.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evs")
public class VoteController {

    private final VoteService voteService;
    private final VoterService voterService;
    private final CandidateService candidateService;
    private final ElectionService electionService;

    @Autowired
    public VoteController(VoteService voteService, VoterService voterService,
                          CandidateService candidateService, ElectionService electionService) {
        this.voteService = voteService;
        this.voterService = voterService;
        this.candidateService = candidateService;
        this.electionService = electionService;
    }

    @GetMapping("/votes")
    public ResponseEntity<?> getVotes() {
        return ResponseEntity.ok(voterService.getAllVoters());
    }

    @GetMapping("/votes/election/{electionId}")
    public ResponseEntity<?> getElectionVotes(@PathVariable long electionId) {
        Election election = electionService.getElectionById(electionId);
        if (election == null) {
            return ResponseEntity.badRequest().body("Election not found");
        }
        return ResponseEntity.ok(voteService.getVotesByElection(election));
    }

    @GetMapping("/votes/candidate/{candidateId}")
    public ResponseEntity<?> getCandidateVotes(@PathVariable long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        if (candidate == null) {
            return ResponseEntity.badRequest().body("Candidate not found");
        }
        return ResponseEntity.ok(voteService.getVotesByCandidate(candidate));
    }

    @PostMapping("/vote/{voterCnic}/{candidateId}/{electionId}")
    public ResponseEntity<?> castVote(@PathVariable String voterCnic, @PathVariable Long candidateId,
                                      @PathVariable Long electionId) {
        Voter voter = voterService.getVoterByCnic(voterCnic);
        if (voter == null) {
            return ResponseEntity.badRequest().body("Voter not found");
        }
        Candidate candidate = candidateService.getCandidateById(candidateId);
        if (candidate == null) {
            return ResponseEntity.badRequest().body("Candidate not found");
        }
        Election election = electionService.getElectionById(electionId);
        if (election == null) {
            return ResponseEntity.badRequest().body("Election not found");
        }
        VoteKey key = new VoteKey();
        key.setElectionID(electionId);
        key.setCandidateID(candidateId);
        key.setVoterID(voter.getVoterID());
        Vote vote = new Vote();
        vote.setId(key);
        vote.setCandidate(candidate);
        vote.setVoter(voter);
        vote.setElection(election);

        vote = voteService.createVote(vote);

        return ResponseEntity.ok(vote);
    }
}
