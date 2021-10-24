package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentsRepository {
    Optional<List<DepartmentsEntity>> findAll();
    Optional<DepartmentsEntity> findById(String deptNo);
    void save(DepartmentsEntity data);
    void deleteById(String deptNo);
}
