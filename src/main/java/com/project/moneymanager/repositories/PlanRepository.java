package com.project.moneymanager.repositories;

import com.project.moneymanager.models.Plan;
import com.project.moneymanager.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<Plan, Long> {
}
