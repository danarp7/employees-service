package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataDeptManagerRepository extends JpaRepository<DeptManagerEntity, DeptManagerId> {

    List<DeptManagerEntity> findByDeptManagerIdEmployeesEntityEmpNo(Integer empNo);

    List<DeptManagerEntity> findByDeptManagerIdDepartmentsEntityDeptNo(String deptNo);
}
