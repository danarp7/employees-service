package com.employees.domain.repository;

import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.infrastructure.repository.mysql.entity.TitlesId;

import java.util.List;
import java.util.Optional;

public interface TitlesRepository {
    Optional<List<TitlesEntity>> findAll();
    Optional<TitlesEntity> findById(TitlesId titlesId);
    Optional<List<TitlesEntity>> findByEmpNo(Integer empNo);
    void save(TitlesEntity data);
    void deleteById(TitlesId titlesId);
}
