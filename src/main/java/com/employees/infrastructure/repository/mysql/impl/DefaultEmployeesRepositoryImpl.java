package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.repository.EmployeesRepository;
import com.employees.infrastructure.repository.mysql.SpringDataEmployeesRepository;
import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultEmployeesRepositoryImpl implements EmployeesRepository {

    @Autowired
    private SpringDataEmployeesRepository repository;

    @Override
    public Optional<List<EmployeesEntity>> findAll() {
        List<EmployeesEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<EmployeesEntity> findById(Integer empNo) {
        return repository.findById(empNo);
    }

    @Override
    public void save(EmployeesEntity data) {
        repository.save(data);
    }

    @Override
    public void deleteById(Integer empNo) {
        repository.deleteById(empNo);
    }

}
