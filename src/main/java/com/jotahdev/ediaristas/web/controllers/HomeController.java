package com.jotahdev.ediaristas.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public ModelAndView home() {
        // Usando "admin/index" para localizar o template corretamente dentro de "templates/admin"
        return new ModelAndView("admin/index");
    }
}
