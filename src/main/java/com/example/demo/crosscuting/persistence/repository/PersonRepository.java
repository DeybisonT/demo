package com.example.demo.crosscuting.persistence.repository;

import com.example.demo.crosscuting.domain.PersonDTO;
import com.example.demo.crosscuting.persistence.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

  @Query(
      "SELECT NEW com.example.demo.crosscuting.domain.PersonDTO(p.id, p.age, p.identification, p.phone, p.name, "
          + "p.gender, p.address) FROM Person p WHERE p.id = :ID_PERSON")
  Optional<PersonDTO> findPersonById(@Param("ID_PERSON") final Long idPerson);
}
