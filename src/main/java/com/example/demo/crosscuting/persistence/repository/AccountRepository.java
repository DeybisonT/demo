package com.example.demo.crosscuting.persistence.repository;

import com.example.demo.crosscuting.persistence.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

  Optional<Account> findAccountByAccountNumber(final Long accountNumber);
}
