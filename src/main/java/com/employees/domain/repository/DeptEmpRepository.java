package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpId;

import java.util.List;
import java.util.Optional;

public interface DeptEmpRepository {
    Optional<List<DeptEmpEntity>> findAll();
    Optional<DeptEmpEntity> findById(DeptEmpId deptEmpId);
    Optional<List<DeptEmpEntity>> findByEmpNo(Integer empNo);
    Optional<List<DeptEmpEntity>> findByDeptNo(String deptNo);
    void save(DeptEmpEntity data);
    void deleteById(DeptEmpId deptEmpId);
}
