package com.jotahdev.ediaristas.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jotahdev.ediaristas.core.models.CleaningService;

@Controller
@RequestMapping("/admin/servicos")
public class CleaningServiceController {

  @GetMapping("/cadastrar")
  public ModelAndView create() {
    ModelAndView modelAndView = new ModelAndView("admin/CleaningService/form"); // Verifique o caminho da view

    modelAndView.addObject("CleaningService", new CleaningService());

    return modelAndView;
  }
}
