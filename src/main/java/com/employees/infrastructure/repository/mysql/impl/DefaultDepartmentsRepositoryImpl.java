package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.exceptions.DuplicateDataException;
import com.employees.domain.repository.DepartmentsRepository;
import com.employees.infrastructure.repository.mysql.SpringDataDepartmentsRepository;
import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultDepartmentsRepositoryImpl implements DepartmentsRepository {

    @Autowired
    private SpringDataDepartmentsRepository repository;

    @Override
    public Optional<List<DepartmentsEntity>> findAll() {
        List<DepartmentsEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<DepartmentsEntity> findById(String deptNo) {
        return repository.findById(deptNo);
    }

    @Override
    public void save(DepartmentsEntity data) {
        try {
            repository.save(data);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateDataException("dept name " + data.getDeptName());
        }
    }

    @Override
    public void deleteById(String deptNo) {
        repository.deleteById(deptNo);
    }

}
