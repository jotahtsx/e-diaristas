package com.jotahdev.ediaristas.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Painel de Controle!");
        return "home"; // A página de boas-vindas
    }
}