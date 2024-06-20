package com.project.voting_system.services;

import com.project.voting_system.models.Voter;
import com.project.voting_system.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter createVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public Voter getVoterById(Long voterID) {
        return voterRepository.findById(voterID).orElse(null);
    }

    public Voter getVoterByCnic(String cnic) {
        return voterRepository.findByCnic(cnic).orElse(null);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter updateVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public void deleteVoter(Long voterID) {
        voterRepository.deleteById(voterID);
    }
}
