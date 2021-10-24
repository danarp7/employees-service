package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.interfaces.web.dto.DeptEmpRequestDto;

import java.util.List;

public interface DeptEmpService {
    List<DeptEmpEntity> findAll();
    DeptEmpEntity findById(Integer empNo, String deptNo);
    void create(DeptEmpRequestDto data);
    void update(DeptEmpRequestDto data);
    void delete(Integer empNo, String deptNo);
}
