package com.jotahdev.ediaristas.web.dtos;

import java.math.BigDecimal;

import com.jotahdev.ediaristas.core.enums.Icon;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningServiceForm {

  @NotNull
  @Size(min = 3, max = 50)
  private String name;

  @NotNull
  @PositiveOrZero
  private BigDecimal minimumPrice;

  @NotNull
  @PositiveOrZero
  private Integer quantityOfHours;

  @NotNull
  @PositiveOrZero
  @Max(100)
  private BigDecimal commissionPercentage;

  @NotNull
  @PositiveOrZero
  private BigDecimal roomHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal roomPrice;

  @NotNull
  @PositiveOrZero
  private BigDecimal livingAreaHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal livingAreaPrice;

  @NotNull
  @PositiveOrZero
  private BigDecimal bathroomHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal bathroomPrice;

  @NotNull
  @PositiveOrZero
  private BigDecimal kitchenHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal kitchenPrice;

  @NotNull
  @PositiveOrZero
  private BigDecimal yardHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal yardPrice;

  @NotNull
  @PositiveOrZero
  private BigDecimal othersHours;

  @NotNull
  @PositiveOrZero
  private BigDecimal othersPrice;

  @NotNull
  private Icon icon;

  @NotNull
  @Positive
  private Integer position;
}