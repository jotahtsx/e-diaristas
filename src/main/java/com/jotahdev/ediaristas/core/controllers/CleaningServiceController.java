package com.jotahdev.ediaristas.core.controllers;

import com.jotahdev.ediaristas.core.enums.Icon;
import com.jotahdev.ediaristas.core.models.CleaningService;
import com.jotahdev.ediaristas.core.repositories.CleaningServiceRepository;
import com.jotahdev.ediaristas.web.dtos.CleaningServiceForm;
import com.jotahdev.ediaristas.web.mappers.WebCleaningServiceMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/admin/servicos")
public class CleaningServiceController {

  @Autowired
  private CleaningServiceRepository repository;

  @Autowired
  private WebCleaningServiceMapper mapper;

  @GetMapping(value = { "/", "" })
  public String listAll(Model model, HttpServletRequest request) {
    model.addAttribute("title", "Serviços");
    model.addAttribute("services", repository.findAll());
    model.addAttribute("currentUrl", request.getRequestURI());

    return "services/index";
  }

  @GetMapping(value = { "/cadastrar", "/cadastrar/" })
  public String showCreateForm(Model model, HttpServletRequest request) {
    model.addAttribute("serviceForm", new CleaningServiceForm());
    model.addAttribute("title", "Novo Serviço");
    model.addAttribute("buttonAction", "create");
    model.addAttribute("currentUrl", request.getRequestURI()); // Passando a URL atual para o modelo

    return "services/form";
  }

  @PostMapping("/cadastrar")
  public String create(@Valid @ModelAttribute("serviceForm") CleaningServiceForm serviceForm,
      BindingResult result,
      Model model,
      HttpServletRequest request) {
    if (result.hasErrors()) {
      model.addAttribute("title", "Novo Serviço");
      model.addAttribute("currentUrl", request.getRequestURI());
      return "services/form"; // Retorna ao formulário com erros
    }

    CleaningService cleaningService = mapper.toModel(serviceForm);
    repository.save(cleaningService);

    return "redirect:/admin/servicos"; // Redireciona para a página de serviços após sucesso
  }

  @GetMapping("/{id}/editar")
  public String showEditForm(@PathVariable Long id, Model model, HttpServletRequest request) {
      int currentYear = Year.now().getValue();
      CleaningService service = repository.findById(id)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
  
      CleaningServiceForm serviceForm = mapper.toForm(service);
  
      model.addAttribute("serviceForm", serviceForm);
      model.addAttribute("title", "Editar Serviço");
      model.addAttribute("buttonAction", "edit");
      model.addAttribute("currentYear", currentYear);
      model.addAttribute("currentUrl", request.getRequestURI()); // Adiciona a URL atual
  
      return "services/form";
  }
  
  @PostMapping("/{id}/editar")
  public String update(@PathVariable Long id,
          @Valid @ModelAttribute("serviceForm") CleaningServiceForm serviceForm,
          BindingResult bindingResult,
          Model model,
          HttpServletRequest request) {
  
      if (bindingResult.hasErrors()) {
          model.addAttribute("currentUrl", request.getRequestURI());
          model.addAttribute("serviceForm", serviceForm);
          model.addAttribute("title", "Editar Serviço");
          model.addAttribute("buttonAction", "edit");
  
          // Log de erros de validação para debug
          bindingResult.getAllErrors().forEach(error -> {
              System.out.println("Erro de validação: " + error.getDefaultMessage());
          });
  
          return "services/form"; // Retorna o formulário com os erros
      }
  
      // Se não houver erros, atualiza
      CleaningService service = mapper.toModel(serviceForm);
      service.setId(id);
      repository.save(service);
  
      return "redirect:/admin/servicos"; // Redireciona para a página de serviços após sucesso
  }

  @GetMapping("/{id}/excluir")
  public String delete(@PathVariable Long id) {
    repository.deleteById(id);
    return "redirect:/admin/servicos";
  }

  @ModelAttribute("icons")
  public Icon[] getIcons() {
    return Icon.values();
  }
}
