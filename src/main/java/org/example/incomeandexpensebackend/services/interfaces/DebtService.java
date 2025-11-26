package org.example.incomeandexpensebackend.services.interfaces;

import org.example.incomeandexpensebackend.dtos.debt.DebtDto;
import org.example.incomeandexpensebackend.services.base_services.*;

public interface DebtService extends Addable<DebtDto>, Modifiable<DebtDto, Long>, FindAll<DebtDto>, FindById<DebtDto, Long>, Removable<Long> {
}
