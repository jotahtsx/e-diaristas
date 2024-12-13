package com.jotahdev.ediaristas.core.controllers;

import com.jotahdev.ediaristas.core.enums.Icon;
import com.jotahdev.ediaristas.web.dtos.CleaningServiceForm;
import com.jotahdev.ediaristas.web.dtos.FlashMessage;
import com.jotahdev.ediaristas.web.services.CleaningWebService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/servicos")
public class CleaningServiceController {

  @Autowired
  private CleaningWebService cleaningWebService;

  @GetMapping(value = { "/", "" })
  public String listAll(Model model, HttpServletRequest request) {
    model.addAttribute("title", "Serviços");
    model.addAttribute("services", cleaningWebService.getAll());
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
  public String create(
          @Valid @ModelAttribute("serviceForm") CleaningServiceForm serviceForm,
          BindingResult result,
          Model model,
          HttpServletRequest request,
          RedirectAttributes attrs) {
      if (result.hasErrors()) {
          model.addAttribute("title", "Novo Serviço");
          model.addAttribute("currentUrl", request.getRequestURI());
          return "services/form"; // Retorna ao formulário com erros
      }
  
      cleaningWebService.create(serviceForm);
      attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço cadastrado com sucesso"));
  
      return "redirect:/admin/servicos"; // Redireciona para a página de serviços após sucesso
  }

  @GetMapping("/{id}/editar")
  public String showEditForm(@PathVariable Long id, Model model, HttpServletRequest request) {
    model.addAttribute("serviceForm", cleaningWebService.findServiceById(id)); // Usando o serviço
    model.addAttribute("title", "Editar Serviço");
    model.addAttribute("buttonAction", "edit");
    model.addAttribute("currentUrl", request.getRequestURI());
    return "services/form";
  }

  @PostMapping("/{id}/editar")
  public String update(
          @PathVariable Long id,
          @Valid @ModelAttribute("serviceForm") CleaningServiceForm serviceForm,
          BindingResult bindingResult,
          Model model,
          HttpServletRequest request,
          RedirectAttributes attrs) {
  
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
  
      // Atualiza o serviço usando o CleaningWebService
      cleaningWebService.edit(serviceForm, id);
  
      // Adiciona uma mensagem de sucesso no Flash Attributes
      attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço atualizado com sucesso!"));
  
      return "redirect:/admin/servicos"; // Redireciona para a página de serviços após sucesso
  }

  @GetMapping("/{id}/excluir")
  public String delete(@PathVariable Long id, RedirectAttributes attrs) {
    attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço deletado com sucesso"));
    cleaningWebService.deleteById(id);
    return "redirect:/admin/servicos"; // Redireciona após exclusão
  }

  @ModelAttribute("icons")
  public Icon[] getIcons() {
    return Icon.values();
  }
}
