package com.project.moneymanager.repositories;

import com.project.moneymanager.models.Balance;
import org.springframework.data.repository.CrudRepository;

public interface Balancerepo extends CrudRepository<Balance, Long> {

}
