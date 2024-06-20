package com.project.voting_system.repository;

import com.project.voting_system.models.Candidate;
import com.project.voting_system.models.Election;
import com.project.voting_system.models.Vote;
import com.project.voting_system.models.VoteKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, VoteKey> {
    List<Vote> findAllByElection(Election election);

    List<Vote> findAllByCandidate(Candidate candidate);
}

