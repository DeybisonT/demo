package com.example.demo.crosscuting.persistence.repository;

import com.example.demo.crosscuting.domain.ResponseMovementDTO;
import com.example.demo.crosscuting.persistence.entity.Movement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends CrudRepository<Movement, Long> {

  @Query(
      "SELECT NEW com.example.demo.crosscuting.domain.ResponseMovementDTO(m.date, c.name, a.accountNumber, "
          + "a.typeAccount, a.openingBalance, m.status, m.typeMovement, m.balance) "
          + "FROM Account a "
          + "INNER JOIN a.movement m ON a.movement.id = m.id "
          + "INNER JOIN a.client c ON a.client.id = c.id WHERE m.date <= :NOW AND m.date >= :NOW and c.name = :NAME")
  List<ResponseMovementDTO> findMovementByDateAndClient(
      @Param("NOW") final Date date, @Param("NAME") final String name);
}
