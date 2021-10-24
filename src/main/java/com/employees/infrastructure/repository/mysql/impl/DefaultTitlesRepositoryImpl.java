package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.repository.TitlesRepository;
import com.employees.infrastructure.repository.mysql.SpringDataTitlesRepository;
import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.infrastructure.repository.mysql.entity.TitlesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultTitlesRepositoryImpl implements TitlesRepository {

    @Autowired
    private SpringDataTitlesRepository repository;

    @Override
    public Optional<List<TitlesEntity>> findAll() {
        List<TitlesEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<TitlesEntity> findById(TitlesId titlesId) {
        return repository.findById(titlesId);
    }

    @Override
    public void save(TitlesEntity data) {
        repository.save(data);
    }

    @Override
    public void deleteById(TitlesId titlesId) {
        repository.deleteById(titlesId);
    }

}
