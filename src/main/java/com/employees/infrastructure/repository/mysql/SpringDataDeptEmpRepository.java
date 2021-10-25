package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataDeptEmpRepository extends JpaRepository<DeptEmpEntity, DeptEmpId> {

    List<DeptEmpEntity> findByDeptEmpIdEmployeesEntityEmpNo(Integer empNo);

    List<DeptEmpEntity> findByDeptEmpIdDepartmentsEntityDeptNo(String deptNo);
}
