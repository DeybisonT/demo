package com.example.demo.crosscuting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class HttpResponseOk<T> {

  @Builder.Default
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "dd-MM-yyyy hh:mm:ss",
      timezone = "America/Bogota")
  private Date timeStamp = new Date();

  private int code;
  private T response;
}
