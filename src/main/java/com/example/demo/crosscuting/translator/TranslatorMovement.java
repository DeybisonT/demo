package com.example.demo.crosscuting.translator;

import com.example.demo.crosscuting.domain.MovementDTO;
import com.example.demo.crosscuting.persistence.entity.Movement;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.DomainTranslator;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
@DomainTranslator
public class TranslatorMovement implements Translator<MovementDTO, Movement> {

  @Override
  public Movement translate(final MovementDTO dto) throws BusinessException {

    return Movement.builder()
        .date(new Date())
        .typeMovement(dto.getTypeMovement())
        .value(dto.getValue())
        .balance(dto.getOpeningBalance())
        .status(dto.getStatus())
        .build();
  }
}
