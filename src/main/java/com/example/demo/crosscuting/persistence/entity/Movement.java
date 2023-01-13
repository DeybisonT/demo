package com.example.demo.crosscuting.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement implements Serializable {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Temporal(TemporalType.DATE)
  private Date date;

  private String typeMovement;
  private String status;
  private Long value;
  private Long balance;
}
