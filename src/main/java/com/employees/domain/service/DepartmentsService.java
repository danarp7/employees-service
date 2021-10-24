package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentsEntity> findAll();
    DepartmentsEntity findById(String deptNo);
    void create(DepartmentsEntity data);
    void update(DepartmentsEntity data);
    void delete(String deptNo);
}
