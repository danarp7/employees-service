package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDeptEmpRepository extends JpaRepository<DeptEmpEntity, DeptEmpId> {
}
