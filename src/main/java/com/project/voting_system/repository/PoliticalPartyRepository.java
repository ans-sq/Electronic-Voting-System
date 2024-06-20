package com.project.voting_system.repository;

import com.project.voting_system.models.PoliticalParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
    Optional<PoliticalParty> findByName(String name);
}
