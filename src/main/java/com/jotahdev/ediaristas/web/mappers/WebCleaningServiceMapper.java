package com.jotahdev.ediaristas.web.mappers;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.jotahdev.ediaristas.core.models.CleaningService;
import com.jotahdev.ediaristas.web.dtos.CleaningServiceForm;

@Component
public class WebCleaningServiceMapper {

  public CleaningService toModel(CleaningServiceForm form) {
    if (form == null) {
      throw new IllegalArgumentException("Formulário não pode ser nulo.");
    }

    var model = new CleaningService();

    model.setName(form.getName());
    model.setMinimumPrice(form.getMinimumPrice());
    model.setQuantityOfHours(form.getQuantityOfHours());
    model.setCommissionPercentage(form.getCommissionPercentage());
    model.setRoomPrice(form.getRoomPrice());
    model.setLivingAreaPrice(form.getLivingAreaPrice());
    model.setBathroomPrice(form.getBathroomPrice());
    model.setKitchenPrice(form.getKitchenPrice());
    model.setYardPrice(form.getYardPrice());
    model.setOthersPrice(form.getOthersPrice());
    model.setIcon(form.getIcon());
    model.setPosition(form.getPosition());
    
    // Alterado para Integer, permitindo valores nulos
    model.setRoomHours(form.getRoomHours() != null ? form.getRoomHours().intValue() : null);  
    model.setLivingAreaHours(form.getLivingAreaHours() != null ? form.getLivingAreaHours().intValue() : null);
    model.setBathroomHours(form.getBathroomHours() != null ? form.getBathroomHours().intValue() : null);  
    model.setKitchenHours(form.getKitchenHours() != null ? form.getKitchenHours().intValue() : null);  
    model.setYardHours(form.getYardHours() != null ? form.getYardHours().intValue() : null);  
    model.setOthersHours(form.getOthersHours() != null ? form.getOthersHours().intValue() : null);

    return model;
  }

  public CleaningServiceForm toForm(CleaningService model) {
    if (model == null) {
      throw new IllegalArgumentException("O modelo não pode ser nulo.");
    }

    var form = new CleaningServiceForm();

    form.setName(model.getName());
    form.setMinimumPrice(model.getMinimumPrice());
    form.setQuantityOfHours(model.getQuantityOfHours());
    form.setCommissionPercentage(model.getCommissionPercentage());
    
    // Conversão para BigDecimal para permitir valores nulos
    form.setRoomHours(model.getRoomHours() != null ? BigDecimal.valueOf(model.getRoomHours()) : null);
    form.setRoomPrice(model.getRoomPrice());
    form.setLivingAreaHours(model.getLivingAreaHours() != null ? BigDecimal.valueOf(model.getLivingAreaHours()) : null);
    form.setLivingAreaPrice(model.getLivingAreaPrice());
    form.setBathroomHours(model.getBathroomHours() != null ? BigDecimal.valueOf(model.getBathroomHours()) : null);
    form.setBathroomPrice(model.getBathroomPrice());
    form.setKitchenHours(model.getKitchenHours() != null ? BigDecimal.valueOf(model.getKitchenHours()) : null);
    form.setKitchenPrice(model.getKitchenPrice());
    form.setYardHours(model.getYardHours() != null ? BigDecimal.valueOf(model.getYardHours()) : null);
    form.setYardPrice(model.getYardPrice());
    form.setOthersHours(model.getOthersHours() != null ? BigDecimal.valueOf(model.getOthersHours()) : null);
    form.setOthersPrice(model.getOthersPrice());
    form.setIcon(model.getIcon());
    form.setPosition(model.getPosition());

    return form;
  }
}
