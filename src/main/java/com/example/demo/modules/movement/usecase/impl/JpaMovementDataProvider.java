package com.example.demo.modules.movement.usecase.impl;

import com.example.demo.crosscuting.domain.RequestMovementDTO;
import com.example.demo.crosscuting.domain.ResponseMovementDTO;
import com.example.demo.crosscuting.persistence.entity.Movement;
import com.example.demo.crosscuting.persistence.repository.MovementRepository;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.modules.movement.dataprovider.MovementDataProvider;
import com.example.demo.stereotypes.DataProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Log4j2
@DataProvider
public class JpaMovementDataProvider implements MovementDataProvider {

  @Autowired private MovementRepository movementRepository;

  public Movement saveOrUpdate(final Movement movement) throws ApplicationException {
    try {
      return movementRepository.save(movement);
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }

  @Override
  public List<ResponseMovementDTO> findMovements(final RequestMovementDTO requestMovementDTO)
      throws ApplicationException {
    try {
      System.out.println(requestMovementDTO.getDate());
      System.out.println(requestMovementDTO.getClient());
      return movementRepository.findMovementByDateAndClient(
          requestMovementDTO.getDate(), requestMovementDTO.getClient());
    } catch (DataAccessException e) {
      throw new ApplicationException("", e.getCause());
    }
  }
}
