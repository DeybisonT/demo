package com.example.demo.crosscuting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO extends PersonDTO {

  private Long clientId;
  private String password;
  private String status;

  @Builder(builderMethodName = "clientDTOBuilder")
  public ClientDTO(
      Long id,
      int age,
      Long phone,
      Long identification,
      String name,
      String gender,
      String address,
      Long clientId,
      String password,
      String status) {
    super(id, age, phone, identification, name, gender, address);
    this.clientId = clientId;
    this.password = password;
    this.status = status;
  }
}
