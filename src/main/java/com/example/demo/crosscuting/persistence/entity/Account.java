package com.example.demo.crosscuting.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private Long accountNumber;
  private Long openingBalance;

  private String typeAccount;
  private String status;

  @ManyToOne
  @JoinColumn(name = "client")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "movement")
  private Movement movement;
}
