package com.example.demo.modules.account.usecase;

import com.example.demo.crosscuting.domain.AccountDTO;
import com.example.demo.crosscuting.persistence.entity.Account;
import com.example.demo.crosscuting.persistence.entity.Client;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.modules.account.dataprovider.AccountDataProvider;
import com.example.demo.modules.client.dataprovider.ClientDataProvider;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.UseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@Log4j2
@UseCase
@Transactional
public class AccountProcess {

  @Autowired private AccountDataProvider accountDataProvider;
  @Autowired private ClientDataProvider clientDataProvider;
  @Autowired private Translator<AccountDTO, Account> accountTranslator;

  public Long createNewAccount(final AccountDTO accountDTO)
      throws BusinessException, ApplicationException {
    Optional<Client> client = clientDataProvider.findClientByName(accountDTO.getClientName());

    Client client1 =
        client.orElseThrow(() -> new BusinessException("" + accountDTO.getClientName()));

    Account account = accountTranslator.translate(accountDTO);
    account.setClient(client1);

    return accountDataProvider.saveOrUpdate(account);
  }
}
