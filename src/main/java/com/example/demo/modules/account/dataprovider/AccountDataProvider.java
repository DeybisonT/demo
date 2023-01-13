package com.example.demo.modules.account.dataprovider;

import com.example.demo.crosscuting.persistence.entity.Account;
import com.example.demo.exceptions.ApplicationException;

import java.util.Optional;

public interface AccountDataProvider {
  Long saveOrUpdate(final Account account) throws ApplicationException;

  Optional<Account> findAccountByAccountNumber(final Long accountNumber) throws ApplicationException;
}
