package com.jotahdev.ediaristas.core.models;

import java.math.BigDecimal;

import com.jotahdev.ediaristas.core.enums.Icon;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "services")
public class CleaningService {

  @EqualsAndHashCode.Include
  @ToString.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String name; // nome

  @Column(name = "minimum_price", nullable = false)
  private BigDecimal minimumPrice; // Valor Mínimo
  @Column(name = "quantity_of_hours", nullable = false)
  private Integer quantityOfHours; // Quantidade de Horas
  @Column(name = "comission_per_percentage", nullable = false)
  private BigDecimal commissionPercentage; // Porcentagem por Comissão

  @Column(name = "room_hours", nullable = false)
  private Integer roomHours; // Horas por Quarto
  @Column(name = "room_price", nullable = false)
  private BigDecimal roomPrice; // Valor por Quarto

  @Column(name = "living_area_hours", nullable = false)
  private Integer livingAreaHours; // Horas por Sala
  @Column(name = "living_area_price", nullable = false)
  private BigDecimal livingAreaPrice; // Valor por Sala

  @Column(name = "bathroom_hours", nullable = false)
  private Integer bathroomHours; // Horas por Banheiro
  @Column(name = "bathroom_price", nullable = false)
  private BigDecimal bathroomPrice; // Valor por Banheiro

  @Column(name = "kitchen_hours", nullable = false)
  private Integer kitchenHours; // Horas por Cozinha
  @Column(name = "kitchen_price", nullable = false)
  private BigDecimal kitchenPrice; // Valor por Cozinha

  @Column(name = "yard_hours", nullable = false)
  private Integer yardHours; // Horas por Quintal
  @Column(name = "yard_price", nullable = false)
  private BigDecimal yardPrice; // Valor por Quintal

  @Column(name = "others_hours", nullable = false)
  private Integer othersHours; // Horas por Outros
  @Column(name = "others_price", nullable = false)
  private BigDecimal othersPrice; // Valor por Outros

  @Column(nullable = false, length = 14)
  @Enumerated(EnumType.STRING)
  private Icon icon; // Ícones do serviço

  @Column(nullable = false)
  private Integer position; // Posição do serviço
}
