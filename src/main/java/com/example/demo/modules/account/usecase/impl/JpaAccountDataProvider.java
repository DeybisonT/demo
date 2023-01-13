package com.example.demo.modules.account.usecase.impl;

import com.example.demo.crosscuting.persistence.entity.Account;
import com.example.demo.crosscuting.persistence.repository.AccountRepository;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.modules.account.dataprovider.AccountDataProvider;
import com.example.demo.stereotypes.DataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

@Log4j2
@DataProvider
public class JpaAccountDataProvider implements AccountDataProvider {

  @Autowired private AccountRepository accountRepository;

  public Long saveOrUpdate(final Account account) throws ApplicationException {
    try {
      return accountRepository.save(account).getId();
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }

  @Override
  public Optional<Account> findAccountByAccountNumber(final Long accountNumber)
      throws ApplicationException {
    try {
      return accountRepository.findAccountByAccountNumber(accountNumber);
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }
}
