package com.example.demo.modules.client.dataprovider;

import com.example.demo.crosscuting.persistence.entity.Client;
import com.example.demo.exceptions.ApplicationException;

import java.util.Optional;

public interface ClientDataProvider {
  Long saveOrUpdate(final Client client) throws ApplicationException;

  Optional<Client> findClientByName(final String name) throws ApplicationException;
}
