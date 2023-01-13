package com.example.demo.modules.movement.usecase;

import com.example.demo.crosscuting.domain.MovementDTO;
import com.example.demo.crosscuting.domain.RequestMovementDTO;
import com.example.demo.crosscuting.domain.ResponseMovementDTO;
import com.example.demo.crosscuting.persistence.entity.Account;
import com.example.demo.crosscuting.persistence.entity.Movement;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.exceptions.BusinessException;
import com.example.demo.modules.account.dataprovider.AccountDataProvider;
import com.example.demo.modules.movement.dataprovider.MovementDataProvider;
import com.example.demo.patterns.Translator;
import com.example.demo.stereotypes.UseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Log4j2
@UseCase
@Transactional
public class MovementProcess {

  @Autowired private MovementDataProvider movementDataProvider;
  @Autowired private AccountDataProvider accountDataProvider;
  @Autowired private Translator<MovementDTO, Movement> movementTranslator;

  public Long createNewMovement(final MovementDTO movementDTO)
      throws BusinessException, ApplicationException {

    Optional<Account> account =
        accountDataProvider.findAccountByAccountNumber(movementDTO.getAccountNumber());

    Account account1 =
        account.orElseThrow(() -> new BusinessException("" + movementDTO.getAccountNumber()));

    Movement movement = movementTranslator.translate(movementDTO);

    movement = movementDataProvider.saveOrUpdate(movement);

    account1.setMovement(movement);

    return movement.getId();
  }

  public List<ResponseMovementDTO> findMovements(final RequestMovementDTO requestMovementDTO)
      throws ApplicationException {
    return movementDataProvider.findMovements(requestMovementDTO);
  }
}
