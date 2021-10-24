package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.repository.SalariesRepository;
import com.employees.infrastructure.repository.mysql.SpringDataSalariesRepository;
import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.infrastructure.repository.mysql.entity.SalariesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultSalariesRepositoryImpl implements SalariesRepository {

    @Autowired
    private SpringDataSalariesRepository repository;

    @Override
    public Optional<List<SalariesEntity>> findAll() {
        List<SalariesEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<SalariesEntity> findById(SalariesId salariesId) {
        return repository.findById(salariesId);
    }

    @Override
    public void save(SalariesEntity data) {
        repository.save(data);
    }

    @Override
    public void deleteById(SalariesId salariesId) {
        repository.deleteById(salariesId);
    }

}
