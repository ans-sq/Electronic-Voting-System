package com.project.voting_system.services;

import com.project.voting_system.models.Candidate;
import com.project.voting_system.models.PoliticalParty;
import com.project.voting_system.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate getCandidateById(Long candidateID) {
        return candidateRepository.findById(candidateID).orElse(null);
    }

    public List<Candidate> getCandidates(PoliticalParty party) {
        return candidateRepository.findByParty(party);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long candidateID) {
        candidateRepository.deleteById(candidateID);
    }
}
