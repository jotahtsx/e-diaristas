package com.jotahdev.ediaristas.core.controllers;

import com.jotahdev.ediaristas.core.enums.Icon;
import com.jotahdev.ediaristas.core.models.CleaningService;

import java.time.Year;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String showCreateForm(Model model) {
        int currentYear = Year.now().getValue();
        model.addAttribute("service", new CleaningService());
        model.addAttribute("title", "Cadastrar novo Serviço");
        model.addAttribute("currentYear", currentYear);
        System.out.println("Ano Atual: " + currentYear);
        return "services/cadastrar";
    }

    @ModelAttribute("icons")
    public Icon[] getIcons() {
      return Icon.values();
    }

    @PostMapping("/cadastrar")
    public String storeService(CleaningService cleaningService) {
        System.out.println(cleaningService);
        return "redirect:/admin/servicos";
    }
}
