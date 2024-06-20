package com.project.voting_system.repository;

import com.project.voting_system.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    Optional<Voter> findByCnic(String cnic);
}

