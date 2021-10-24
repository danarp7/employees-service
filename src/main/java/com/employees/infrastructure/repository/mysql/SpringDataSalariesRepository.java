package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.infrastructure.repository.mysql.entity.SalariesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSalariesRepository extends JpaRepository<SalariesEntity, SalariesId> {
}
