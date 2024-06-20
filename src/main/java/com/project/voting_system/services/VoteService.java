package com.project.voting_system.services;

import com.project.voting_system.models.Candidate;
import com.project.voting_system.models.Election;
import com.project.voting_system.models.Vote;
import com.project.voting_system.models.VoteKey;
import com.project.voting_system.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote getVoteById(VoteKey id) {
        return voteRepository.findById(id).orElse(null);
    }

    public List<Vote> getVotesByElection(Election election) {
        return voteRepository.findAllByElection(election);
    }

    public List<Vote> getVotesByCandidate(Candidate candidate) {
        return voteRepository.findAllByCandidate(candidate);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public void deleteVote(VoteKey id) {
        voteRepository.deleteById(id);
    }
}
