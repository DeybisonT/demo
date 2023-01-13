package com.example.demo.crosscuting.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Person implements Serializable {

  private UUID clientId;
  private String password;
  private String status;

  @Builder(builderMethodName = "clientBuilder")
  public Client(
      Long id,
      int age,
      Long phone,
      Long identification,
      String name,
      String gender,
      String address,
      UUID clientId,
      String password,
      String status) {
    super(id, age, phone, identification, name, gender, address);
    this.clientId = clientId;
    this.password = password;
    this.status = status;
  }
}
