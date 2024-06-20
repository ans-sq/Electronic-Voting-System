package com.project.voting_system.repository;

import com.project.voting_system.models.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConstituencyRepository extends JpaRepository<Constituency, Long> {
    List<Constituency> findConstituenciesByType(String type);
    Boolean existsByNameAndType(String name, String type);
}

