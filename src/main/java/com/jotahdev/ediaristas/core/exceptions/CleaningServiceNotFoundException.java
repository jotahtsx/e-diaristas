package com.jotahdev.ediaristas.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class CleaningServiceNotFoundException extends EntityNotFoundException {

  public CleaningServiceNotFoundException(String message) {
    super(message);
  }
  
}
