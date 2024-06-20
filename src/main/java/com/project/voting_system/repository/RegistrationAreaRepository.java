package com.project.voting_system.repository;

import com.project.voting_system.models.RegistrationArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationAreaRepository extends JpaRepository<RegistrationArea, Long> {
    Boolean existsByName(String name);
}

