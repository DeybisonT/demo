package com.example.demo.crosscuting.persistence.repository;

import com.example.demo.crosscuting.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientsRepository extends CrudRepository<Client, Long> {

  Optional<Client> findClientByName(final String name);
}
