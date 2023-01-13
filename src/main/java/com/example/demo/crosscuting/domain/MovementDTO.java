package com.example.demo.crosscuting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementDTO {

  private Long accountNumber;
  private String typeMovement;
  private Long openingBalance;
  private String status;
  private Long value;
}
