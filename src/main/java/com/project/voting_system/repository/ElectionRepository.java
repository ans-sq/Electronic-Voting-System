package com.project.voting_system.repository;

import com.project.voting_system.models.Election;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    Boolean existsByDateAndType(String date, String type);
    List<Election> findByType(String type);
}

