package com.jotahdev.ediaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotahdev.ediaristas.core.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
