package com.jotahdev.ediaristas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jotahdev.ediaristas.core.exceptions.CleaningServiceNotFoundException;
import com.jotahdev.ediaristas.core.models.CleaningService;
import com.jotahdev.ediaristas.core.repositories.CleaningServiceRepository;
import com.jotahdev.ediaristas.web.dtos.CleaningServiceForm;
import com.jotahdev.ediaristas.web.mappers.WebCleaningServiceMapper;

@Service
public class CleaningWebService {
  
  @Autowired
  private  CleaningServiceRepository repository;

  @Autowired
  WebCleaningServiceMapper mapper;

  public List<CleaningService> getAll() {
    return repository.findAll();
  }

  public CleaningService create(CleaningServiceForm form) {
    var model = mapper.toModel(form);

    return repository.save(model);
  }

  public CleaningService findServiceById(Long id) {
    var foundCleaningService = repository.findById(id);

    if(foundCleaningService.isPresent()) {
      return foundCleaningService.get();
    }

    var message = String.format("Serviço com o ID %id não encontrado", id);
    throw new CleaningServiceNotFoundException(message);

  }

}
