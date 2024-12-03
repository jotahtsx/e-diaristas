package com.jotahdev.ediaristas.core.controllers;

import com.jotahdev.ediaristas.core.enums.Icon;
import com.jotahdev.ediaristas.core.models.CleaningService;
import com.jotahdev.ediaristas.core.repositories.CleaningServiceRepository;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/servicos")
public class CleaningServiceController {

    @Autowired
    private CleaningServiceRepository repository;

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
        return "services/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String create(CleaningService cleaningService) {
      repository.save(cleaningService);

      return "redirect:/admin/servicos/cadastrar";
    }

    @ModelAttribute("icons")
    public Icon[] getIcons() {
      return Icon.values();
    }
}
