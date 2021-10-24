package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.repository.DeptManagerRepository;
import com.employees.infrastructure.repository.mysql.SpringDataDeptManagerRepository;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultDeptManagerRepositoryImpl implements DeptManagerRepository {

    @Autowired
    private SpringDataDeptManagerRepository repository;

    @Override
    public Optional<List<DeptManagerEntity>> findAll() {
        List<DeptManagerEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<DeptManagerEntity> findById(DeptManagerId deptManagerId) {
        return repository.findById(deptManagerId);
    }

    @Override
    public void save(DeptManagerEntity data) {
        repository.save(data);
    }

    @Override
    public void deleteById(DeptManagerId deptManagerId) {
        repository.deleteById(deptManagerId);
    }

}
