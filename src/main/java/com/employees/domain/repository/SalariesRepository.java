package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.infrastructure.repository.mysql.entity.SalariesId;

import java.util.List;
import java.util.Optional;

public interface SalariesRepository {
    Optional<List<SalariesEntity>> findAll();
    Optional<SalariesEntity> findById(SalariesId salariesId);
    Optional<List<SalariesEntity>> findByEmpNo(Integer empNo);
    void save(SalariesEntity data);
    void deleteById(SalariesId salariesId);
}
