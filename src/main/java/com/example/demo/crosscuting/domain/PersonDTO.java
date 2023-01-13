package com.example.demo.crosscuting.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

  private Long id;
  private int age;

  private Long identification;
  private Long phone;

  private String name;
  private String gender;
  private String address;
}
