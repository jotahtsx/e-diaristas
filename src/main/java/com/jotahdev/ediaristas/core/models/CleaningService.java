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
  private String name;

  @Column(name = "minimum_price", nullable = false)
  private BigDecimal minimumPrice;
  @Column(name = "quantity_of_hours", nullable = false)
  private Integer quantityOfHours;

  @Column(name = "comission_per_percentage", nullable = false)
  private BigDecimal commissionPercentage;
  @Column(name = "room_hours", nullable = false)
  private Integer roomHours;

  @Column(name = "room_price", nullable = false)
  private BigDecimal roomPrice;
  @Column(name = "living_area_hours", nullable = false)
  private Integer livingAreaHours;

  @Column(name = "living_area_price", nullable = false)
  private BigDecimal livingAreaPrice;
  @Column(name = "bathroom_hours", nullable = false)
  private Integer bathroomHours;
  @Column(name = "bathroom_price", nullable = false)
  private BigDecimal bathroomPrice;

  @Column(name = "kitchen_hours", nullable = false)
  private Integer kitchenHours;
  @Column(name = "kitchen_price", nullable = false)
  private BigDecimal kitchenPrice;

  @Column(name = "yard_hours", nullable = false)
  private Integer yardHours;
  @Column(name = "yard_price", nullable = false)
  private BigDecimal yardPrice;

  @Column(name = "others_hours", nullable = false)
  private Integer othersHours;
  @Column(name = "others_price", nullable = false)
  private BigDecimal othersPrice;

  @Column(nullable = false, length = 14)
  @Enumerated(EnumType.STRING)
  private Icon icon;

  @Column(nullable = false)
  private Integer position;
}
