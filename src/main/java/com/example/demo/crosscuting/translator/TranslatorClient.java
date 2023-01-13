package com.example.demo.crosscuting.translator;

import com.example.demo.crosscuting.domain.ClientDTO;
import com.example.demo.crosscuting.persistence.entity.Client;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.DomainTranslator;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Log4j2
@DomainTranslator
public class TranslatorClient implements Translator<ClientDTO, Client> {

  @Override
  public Client translate(final ClientDTO dto) throws BusinessException {
    return Client.clientBuilder()
        .age(dto.getAge())
        .identification(dto.getIdentification())
        .phone(dto.getPhone())
        .name(dto.getName())
        .gender(dto.getGender())
        .address(dto.getAddress())
        .clientId(UUID.randomUUID())
        .password(dto.getPassword())
        .status(dto.getStatus())
        .build();
  }
}
