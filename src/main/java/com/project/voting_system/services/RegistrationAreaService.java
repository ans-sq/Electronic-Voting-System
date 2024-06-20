package com.project.voting_system.services;

import com.project.voting_system.models.RegistrationArea;
import com.project.voting_system.repository.RegistrationAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationAreaService {

    private final RegistrationAreaRepository registrationAreaRepository;

    @Autowired
    public RegistrationAreaService(RegistrationAreaRepository registrationAreaRepository) {
        this.registrationAreaRepository = registrationAreaRepository;
    }

    public RegistrationArea createRegistrationArea(RegistrationArea registrationArea) {
        return registrationAreaRepository.save(registrationArea);
    }

    public Boolean registrationAreaExists(String area) {
        return registrationAreaRepository.existsByName(area);
    }

    public RegistrationArea getRegistrationAreaById(Long areaID) {
        return registrationAreaRepository.findById(areaID).orElse(null);
    }

    public List<RegistrationArea> getAllRegistrationAreas() {
        return registrationAreaRepository.findAll();
    }

    public RegistrationArea updateRegistrationArea(RegistrationArea registrationArea) {
        return registrationAreaRepository.save(registrationArea);
    }

    public void deleteRegistrationArea(Long areaID) {
        registrationAreaRepository.deleteById(areaID);
    }
}
