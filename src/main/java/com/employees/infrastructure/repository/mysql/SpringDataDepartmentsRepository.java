package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDepartmentsRepository extends JpaRepository<DepartmentsEntity, String> {
}
