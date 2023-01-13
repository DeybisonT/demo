package com.example.demo.modules.movement.dataprovider;

import com.example.demo.crosscuting.domain.RequestMovementDTO;
import com.example.demo.crosscuting.domain.ResponseMovementDTO;
import com.example.demo.crosscuting.persistence.entity.Movement;
import com.example.demo.exceptions.ApplicationException;

import java.util.List;

public interface MovementDataProvider {
  Movement saveOrUpdate(final Movement movement) throws ApplicationException;

  List<ResponseMovementDTO> findMovements(final RequestMovementDTO requestMovementDTO)
      throws ApplicationException;
}
