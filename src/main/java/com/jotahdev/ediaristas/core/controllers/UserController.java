package com.jotahdev.ediaristas.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jotahdev.ediaristas.web.services.UserWebService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/usuarios")
public class UserController {

  @Autowired
  private UserWebService UserWebService;
  
  @GetMapping(value = { "/", "" })
  public String listAll(Model model, HttpServletRequest request) {
    model.addAttribute("title", "Usuários");
    model.addAttribute("services", UserWebService.getAll());
    model.addAttribute("currentUrl", request.getRequestURI());

    return "users/index";
  }

}
