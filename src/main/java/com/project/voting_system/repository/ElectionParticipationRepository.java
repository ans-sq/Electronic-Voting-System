package com.project.voting_system.repository;

import com.project.voting_system.models.ElectionParticipation;
import com.project.voting_system.models.ElectionParticipationKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionParticipationRepository extends JpaRepository<ElectionParticipation, ElectionParticipationKey> {
}

