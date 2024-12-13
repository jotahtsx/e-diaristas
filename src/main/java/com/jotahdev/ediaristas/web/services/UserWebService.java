package com.jotahdev.ediaristas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotahdev.ediaristas.core.models.User;
import com.jotahdev.ediaristas.core.repositories.UserRepository;

@Service
public class UserWebService {

  @Autowired
  private UserRepository repository;

  public List<User> getAll(){
    return repository.findAll();
  }

}
