package com.jotahdev.ediaristas.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

  @GetMapping(value = { "/", "" })
  public String dashboard(Model model, HttpServletRequest request) {
    String currentUrl = request.getRequestURI(); // Obtém a URL atual
    model.addAttribute("currentUrl", currentUrl);
    model.addAttribute("title", "Visão Geral");
    return "admin/home";
  }
}
