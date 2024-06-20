package com.project.voting_system.services;

import com.project.voting_system.models.ElectionParticipation;
import com.project.voting_system.models.ElectionParticipationKey;
import com.project.voting_system.repository.ElectionParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionParticipationService {

    private final ElectionParticipationRepository electionParticipationRepository;

    @Autowired
    public ElectionParticipationService(ElectionParticipationRepository electionParticipationRepository) {
        this.electionParticipationRepository = electionParticipationRepository;
    }

    public ElectionParticipation createElectionParticipation(ElectionParticipation electionParticipation) {
        return electionParticipationRepository.save(electionParticipation);
    }

    public ElectionParticipation getElectionParticipationById(ElectionParticipationKey id) {
        return electionParticipationRepository.findById(id).orElse(null);
    }

    public List<ElectionParticipation> getAllElectionParticipations() {
        return electionParticipationRepository.findAll();
    }

    public ElectionParticipation updateElectionParticipation(ElectionParticipation electionParticipation) {
        return electionParticipationRepository.save(electionParticipation);
    }

    public void deleteElectionParticipation(ElectionParticipationKey id) {
        electionParticipationRepository.deleteById(id);
    }
}
