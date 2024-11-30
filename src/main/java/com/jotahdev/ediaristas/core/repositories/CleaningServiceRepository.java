package com.jotahdev.ediaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.ediaristas.core.models.CleaningService;

public interface CleaningServiceRepository extends JpaRepository<CleaningService, Long> {
  
}
