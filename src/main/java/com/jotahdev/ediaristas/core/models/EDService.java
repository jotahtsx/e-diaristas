package com.jotahdev.ediaristas.core.models;

import java.math.BigDecimal;

import com.jotahdev.ediaristas.core.enums.Icon;

import jakarta.persistence.Entity;

@Entity
public class EDService {
  
  private Long id;
  private String name; // nome
  private BigDecimal minimumPrice; // Valor Mínimo
  private Integer quantityOfHours; // Quantidade de Horas
  private BigDecimal commissionPercentage; // Porcentagem por Comissão
  
  private Integer roomHours; // Horas por Quarto
  private BigDecimal roomPrice; // Valor por Quarto
  
  private Integer livingAreaHours; // Horas por Sala
  private BigDecimal livingAreaPrice; // Valor por Sala
  
  private Integer bathroomHours; // Horas por Banheiro
  private BigDecimal bathroomPrice; // Valor por Banheiro
  
  private Integer kitchenHours; // Horas por Cozinha
  private BigDecimal kitchenPrice; // Valor por Cozinha
  
  private Integer yardHours; // Horas por Quintal
  private BigDecimal yardPrice; // Valor por Quintal
  
  private Integer othersHours; // Horas por Outros
  private BigDecimal othersPrice; // Valor por Outros
  
  private Icon icon; //Ícones do serviço
  
  private Integer posição; //Posição do serviço

}
