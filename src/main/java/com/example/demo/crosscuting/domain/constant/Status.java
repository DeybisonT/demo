package com.example.demo.crosscuting.domain.constant;

import lombok.Getter;

@Getter
public enum Status {

  A("A", "Activo"),
  I("I", "Inactivo");

  private String code;
  private String name;

  Status(final String code, final String name) {
    this.code = code;
    this.name = name;
  }
}
