package com.example.demo.crosscuting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

  private Long id;
  private Long accountNumber;
  private Long openingBalance;

  private String typeAccount;
  private String status;
  private String clientName;
}
