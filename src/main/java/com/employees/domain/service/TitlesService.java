package com.employees.domain.service;

import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.interfaces.web.dto.TitlesRequestDto;

import java.util.Date;
import java.util.List;

public interface TitlesService {
    List<TitlesEntity> findAll();
    TitlesEntity findById(Integer empNo, String title, Date fromDate);
    List<TitlesEntity> findByEmpNo(Integer empNo);
    void create(TitlesRequestDto data);
    void update(TitlesRequestDto data);
    void delete(Integer empNo, String title, Date fromDate);
}
