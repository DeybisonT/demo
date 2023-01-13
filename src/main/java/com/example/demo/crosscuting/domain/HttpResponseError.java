package com.example.demo.crosscuting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class HttpResponseError {

  @Builder.Default
  @JsonFormat(
      shape = JsonFormat.Shape.STRING,
      pattern = "dd-MM-yyyy hh:mm:ss",
      timezone = "America/Bogota")
  private Date timeStamp = new Date();

  private int code;
  private String reason;
  private String message;
  private Throwable parentException;
}
