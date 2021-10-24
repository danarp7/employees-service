package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository {
    Optional<List<EmployeesEntity>> findAll();
    Optional<EmployeesEntity> findById(Integer empNo);
    void save(EmployeesEntity data);
    void deleteById(Integer empNo);
}
