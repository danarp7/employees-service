package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDeptManagerRepository extends JpaRepository<DeptManagerEntity, DeptManagerId> {
}
