package com.project.voting_system.services;

import com.project.voting_system.models.Constituency;
import com.project.voting_system.repository.ConstituencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstituencyService {

    private final ConstituencyRepository constituencyRepository;

    @Autowired
    public ConstituencyService(ConstituencyRepository constituencyRepository) {
        this.constituencyRepository = constituencyRepository;
    }

    public Constituency createConstituency(Constituency constituency) {
        return constituencyRepository.save(constituency);
    }

    public Boolean constituencyExists(String name, String type) {
        return constituencyRepository.existsByNameAndType(name, type);
    }

    public Constituency getConstituencyById(Long constituencyID) {
        return constituencyRepository.findById(constituencyID).orElse(null);
    }

    public List<Constituency> getAllConstituencies() {
        return constituencyRepository.findAll();
    }

    public List<Constituency> getConstituenciesByType(String type) {
        return constituencyRepository.findConstituenciesByType(type);
    }

    public Constituency updateConstituency(Constituency constituency) {
        return constituencyRepository.save(constituency);
    }

    public void deleteConstituency(Long constituencyID) {
        constituencyRepository.deleteById(constituencyID);
    }
}
