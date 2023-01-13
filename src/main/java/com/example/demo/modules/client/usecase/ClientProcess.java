package com.example.demo.modules.client.usecase;

import com.example.demo.crosscuting.domain.ClientDTO;
import com.example.demo.crosscuting.persistence.entity.Client;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.modules.client.dataprovider.ClientDataProvider;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.UseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Log4j2
@UseCase
@Transactional
public class ClientProcess {

  @Autowired private ClientDataProvider clientDataProvider;
  @Autowired private Translator<ClientDTO, Client> clientTranslator;

  public Long createNewClient(final ClientDTO clientDTO)
      throws BusinessException, ApplicationException {
    Client client = clientTranslator.translate(clientDTO);
    return clientDataProvider.saveOrUpdate(client);
  }
}
