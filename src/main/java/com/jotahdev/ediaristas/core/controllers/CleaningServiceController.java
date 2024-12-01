package com.jotahdev.ediaristas.core.controllers;

import com.jotahdev.ediaristas.core.models.CleaningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/servicos")
public class CleaningServiceController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalServices", 120);
        model.addAttribute("totalRevenue", 5000.00);
        model.addAttribute("totalCleaners", 45);
        return "home";
    }

    @GetMapping("/cadastrar")
    public String showCadastroForm(Model model) {
        model.addAttribute("service", new CleaningService());
        return "services/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarService(CleaningService cleaningService) {
        System.out.println(cleaningService);
        return "redirect:/admin/servicos";
    }
}
