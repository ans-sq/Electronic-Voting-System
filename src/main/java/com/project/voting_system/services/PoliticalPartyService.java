package com.project.voting_system.services;

import com.project.voting_system.models.PoliticalParty;
import com.project.voting_system.repository.PoliticalPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliticalPartyService {

    private final PoliticalPartyRepository politicalPartyRepository;

    @Autowired
    public PoliticalPartyService(PoliticalPartyRepository politicalPartyRepository) {
        this.politicalPartyRepository = politicalPartyRepository;
    }

    public PoliticalParty createPoliticalParty(PoliticalParty politicalParty) {
        return politicalPartyRepository.save(politicalParty);
    }

    public PoliticalParty getPoliticalPartyById(Long partyID) {
        return politicalPartyRepository.findById(partyID).orElse(null);
    }

    public Optional<PoliticalParty> getPoliticalPartyByName(String name) {
        return politicalPartyRepository.findByName(name);
    }

    public List<PoliticalParty> getAllPoliticalParties() {
        return politicalPartyRepository.findAll();
    }

    public PoliticalParty updatePoliticalParty(PoliticalParty politicalParty) {
        return politicalPartyRepository.save(politicalParty);
    }

    public void deletePoliticalParty(Long partyID) {
        politicalPartyRepository.deleteById(partyID);
    }
}
