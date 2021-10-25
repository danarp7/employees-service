package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerId;

import java.util.List;
import java.util.Optional;

public interface DeptManagerRepository {
    Optional<List<DeptManagerEntity>> findAll();
    Optional<DeptManagerEntity> findById(DeptManagerId deptManagerId);
    Optional<List<DeptManagerEntity>> findByEmpNo(Integer empNo);
    Optional<List<DeptManagerEntity>> findByDeptNo(String deptNo);
    void save(DeptManagerEntity data);
    void deleteById(DeptManagerId deptManagerId);
}
