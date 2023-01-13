package com.example.demo.crosscuting.translator;

import com.example.demo.crosscuting.domain.PersonDTO;
import com.example.demo.crosscuting.persistence.entity.Person;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.DomainTranslator;
import lombok.extern.log4j.Log4j2;

@Log4j2
@DomainTranslator
public class TranslatorPerson implements Translator<PersonDTO, Person> {

  @Override
  public Person translate(final PersonDTO dto) throws BusinessException {

    return Person.builder()
        .id(dto.getId())
        .age(dto.getAge())
        .phone(dto.getPhone())
        .identification(dto.getIdentification())
        .name(dto.getName())
        .gender(dto.getGender())
        .address(dto.getAddress())
        .build();
  }
}
