package com.example.demo.modules.movement.api;

import com.example.demo.crosscuting.domain.HttpResponseOk;
import com.example.demo.crosscuting.domain.MovementDTO;
import com.example.demo.crosscuting.domain.RequestMovementDTO;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.modules.movement.usecase.MovementProcess;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.exceptions.ExceptionHandling.createHttpResponseOk;
import static org.springframework.http.HttpStatus.CREATED;

@Log4j2
@RestController
@RequestMapping(
    value = "/movimientos",
    produces = {MediaType.APPLICATION_JSON_VALUE})
public class MovementWebApi {

  @Autowired private MovementProcess movementProcess;

  @PostMapping("/save")
  public ResponseEntity<HttpResponseOk> addNewMovement(@RequestBody final MovementDTO movementDTO)
      throws BusinessException, ApplicationException {
    return createHttpResponseOk(CREATED, movementProcess.createNewMovement(movementDTO));
  }

  @PostMapping("/")
  public ResponseEntity<HttpResponseOk> findMovement(@RequestBody final RequestMovementDTO RequestMovementDTO)
          throws BusinessException, ApplicationException {
    return createHttpResponseOk(CREATED, movementProcess.findMovements(RequestMovementDTO));
  }
}
