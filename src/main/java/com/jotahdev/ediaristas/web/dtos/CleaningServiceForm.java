package com.jotahdev.ediaristas.web.dtos;

import java.math.BigDecimal;

import com.jotahdev.ediaristas.core.enums.Icon;

import jakarta.validation.constraints.DecimalMin;
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
  @Size(min = 3, max = 50, message = "O título deve ter entre 3 e 50 caracteres.")
  private String name;

  @NotNull(message = "O valor mínimo não pode ser vazio.")
  @DecimalMin(value = "0.0", inclusive = true, message = "O valor mínimo deve ser maior ou igual a 0.")
  private BigDecimal minimumPrice;

  @NotNull(message = "A quantidade de horas não pode ser vazia.")
  @PositiveOrZero(message = "A quantidade de horas deve ser maior ou igual a 0.")
  private Integer quantityOfHours;

  @NotNull(message = "A porcentagem da comissão não pode ser vazia.")
  @PositiveOrZero(message = "A porcentagem da comissão deve ser maior ou igual a 0.")
  @Max(value = 100, message = "A porcentagem da comissão não pode ser maior que 100%.")
  private BigDecimal commissionPercentage;

  @NotNull(message = "É preciso setar um valor de horas por quarto.")
  @PositiveOrZero(message = "A quantidade de horas por quarto deve ser maior ou igual a 0.")
  private BigDecimal roomHours;

  @NotNull(message = "Informe o valor do quarto.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal roomPrice;

  @NotNull(message = "É preciso setar um valor de horas por sala.")
  @PositiveOrZero(message = "A quantidade de horas por sala deve ser maior ou igual a 0.")
  private BigDecimal livingAreaHours;

  @NotNull(message = "Informe o valor da sala.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal livingAreaPrice;

  @NotNull(message = "É preciso setar um valor de horas por banheiro.")
  @PositiveOrZero(message = "A quantidade de horas por sala deve ser maior ou igual a 0.")
  private BigDecimal bathroomHours;

  @NotNull(message = "Informe o valor do banheiro.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal bathroomPrice;

  @NotNull(message = "É preciso setar um valor de horas por cozinha.")
  @PositiveOrZero(message = "A quantidade de horas por cozinha deve ser maior ou igual a 0.")
  private BigDecimal kitchenHours;

  @NotNull(message = "Informe o valor da cozinha.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal kitchenPrice;

  @NotNull(message = "É preciso setar um valor de horas por quintal.")
  @PositiveOrZero(message = "A quantidade de horas por quintal deve ser maior ou igual a 0.")
  private BigDecimal yardHours;

  @NotNull(message = "Informe o valor do quintal.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal yardPrice;

  @NotNull(message = "Insira o número de horas para serviços adicionais.")
  @PositiveOrZero(message = "As horas devem ser 0 ou mais.")
  private BigDecimal othersHours;

  @NotNull(message = "Defina o valor dos serviços adicionais.")
  @PositiveOrZero(message = "O valor deve ser 0 ou mais.")
  private BigDecimal othersPrice;

  @NotNull
  private Icon icon;

  @NotNull
  @Positive
  private Integer position;
}