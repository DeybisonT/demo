package com.example.demo.crosscuting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMovementDTO {

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date date;

  private String client;
  private Long accountNumber;
  private String typeAccount;
  private Long openingBalance;
  private String status;
  private String typeMovement;
  private Long balance;
}
