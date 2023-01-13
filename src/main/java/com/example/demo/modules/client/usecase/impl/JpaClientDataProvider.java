package com.example.demo.modules.client.usecase.impl;

import com.example.demo.crosscuting.persistence.entity.Client;
import com.example.demo.crosscuting.persistence.repository.ClientsRepository;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.modules.client.dataprovider.ClientDataProvider;
import com.example.demo.stereotypes.DataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

@Log4j2
@DataProvider
public class JpaClientDataProvider implements ClientDataProvider {

  @Autowired private ClientsRepository clientsRepository;

  public Long saveOrUpdate(final Client client) throws ApplicationException {
    try {
      return clientsRepository.save(client).getId();
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }

  @Override
  public Optional<Client> findClientByName(final String name) throws ApplicationException {
    try {
      return clientsRepository.findClientByName(name);
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }
}
