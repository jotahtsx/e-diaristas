package com.jotahdev.ediaristas.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.Year;

@Controller
public class HomeController {

  @GetMapping({ "/admin", "/admin/" })
  public String home(Model model) {
    int currentYear = Year.now().getValue();
    model.addAttribute("title", "Visão Geral");
    model.addAttribute("currentYear", currentYear);
    System.out.println("Ano Atual: " + currentYear);
    return "home";
  }
}
