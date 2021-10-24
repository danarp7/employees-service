package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.interfaces.web.dto.DeptManagerRequestDto;

import java.util.List;

public interface DeptManagerService {
    List<DeptManagerEntity> findAll();
    DeptManagerEntity findById(String deptNo, Integer empNo);
    void create(DeptManagerRequestDto data);
    void update(DeptManagerRequestDto data);
    void delete(String deptNo, Integer empNo);
}
