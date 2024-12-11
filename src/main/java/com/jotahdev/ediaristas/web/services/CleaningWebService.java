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
  private CleaningServiceRepository repository;

  @Autowired
  private WebCleaningServiceMapper mapper;

  public List<CleaningService> getAll() {
    return repository.findAll();
  }

  public CleaningService create(CleaningServiceForm form) {
    var model = mapper.toModel(form);
    return repository.save(model);
  }

  public CleaningService findServiceById(Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new CleaningServiceNotFoundException(
        String.format("Serviço com o ID %d não encontrado", id)));
  }

  public CleaningService edit(CleaningServiceForm form, Long id) {
    var foundCleaningService = findServiceById(id);

    var model = mapper.toModel(form);
    model.setId(foundCleaningService.getId());

    return repository.save(model);
  }

  public void deleteById(Long id) {
    var foundCleaningService = findServiceById(id);
    repository.delete(foundCleaningService);
  }
}
