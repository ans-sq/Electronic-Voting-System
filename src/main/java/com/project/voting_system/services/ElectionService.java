package com.project.voting_system.services;

import com.project.voting_system.models.Election;
import com.project.voting_system.repository.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    @Autowired
    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    public Boolean electionsExists(String date, String type) {
        return electionRepository.existsByDateAndType(date, type);
    }

    public Election getElectionById(Long electionID) {
        return electionRepository.findById(electionID).orElse(null);
    }

    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    public List<Election> getElectionsByType(String type) {
        return electionRepository.findByType(type);
    }

    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    public void deleteElection(Long electionID) {
        electionRepository.deleteById(electionID);
    }
}
