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
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private int age;

  private Long phone;
  private Long identification;

  private String name;
  private String gender;
  private String address;
}
