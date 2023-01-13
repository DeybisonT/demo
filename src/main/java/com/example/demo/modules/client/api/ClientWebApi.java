package com.example.demo.modules.client.api;

import com.example.demo.crosscuting.domain.ClientDTO;
import com.example.demo.crosscuting.domain.HttpResponseOk;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.modules.client.usecase.ClientProcess;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.exceptions.ExceptionHandling.createHttpResponseOk;
import static org.springframework.http.HttpStatus.CREATED;

@Log4j2
@RestController
@RequestMapping(
    value = "/clientes",
    produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientWebApi {

  @Autowired private ClientProcess clientProcess;

  @PostMapping("/save")
  public ResponseEntity<HttpResponseOk> addNewClient(@RequestBody final ClientDTO clientDTO)
      throws BusinessException, ApplicationException {
    return createHttpResponseOk(CREATED, clientProcess.createNewClient(clientDTO));
  }
}
