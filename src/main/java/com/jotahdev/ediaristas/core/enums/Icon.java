package com.jotahdev.ediaristas.core.enums;

public enum Icon {

  JDV_CLEANING_1("jdv-cleaning-1"),
  JDV_CLEANING_2("jdv-cleaning-2"),
  JDV_CLEANING_3("jdv-cleaning-3");

  private String name;

  private Icon(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
