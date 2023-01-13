package com.example.demo.crosscuting.translator;

import com.example.demo.crosscuting.domain.AccountDTO;
import com.example.demo.crosscuting.persistence.entity.Account;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.DomainTranslator;
import lombok.extern.log4j.Log4j2;

@Log4j2
@DomainTranslator
public class TranslatorAccount implements Translator<AccountDTO, Account> {

  @Override
  public Account translate(final AccountDTO dto) throws BusinessException {

    return Account.builder()
        .accountNumber(dto.getAccountNumber())
        .typeAccount(dto.getTypeAccount())
        .openingBalance(dto.getOpeningBalance())
        .status(dto.getStatus())
        .build();
  }
}
