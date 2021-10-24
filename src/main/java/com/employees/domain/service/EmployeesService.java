package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;

import java.util.List;

public interface EmployeesService {
    List<EmployeesEntity> findAll();
    EmployeesEntity findById(Integer empNo);
    void create(EmployeesEntity data);
    void update(EmployeesEntity data);
    void delete(Integer empNo);
}
