package com.project.voting_system.repository;

import com.project.voting_system.models.Candidate;
import com.project.voting_system.models.PoliticalParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByParty(PoliticalParty party);
}

