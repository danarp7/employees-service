package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.interfaces.web.dto.SalariesRequestDto;

import java.util.Date;
import java.util.List;

public interface SalariesService {
    List<SalariesEntity> findAll();
    SalariesEntity findById(Integer empNo, Date fromDate);
    void create(SalariesRequestDto data);
    void update(SalariesRequestDto data);
    void delete(Integer empNo, Date fromDate);
}
