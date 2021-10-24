package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {
}
