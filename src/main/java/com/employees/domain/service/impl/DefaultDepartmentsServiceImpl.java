package com.employees.domain.service.impl;

import com.employees.domain.exceptions.AlreadyExistException;
import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.DepartmentsRepository;
import com.employees.domain.service.DepartmentsService;
import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Override
    public DepartmentsEntity findById(String deptNo) {
        return departmentsRepository.findById(deptNo)
                .orElseThrow(() -> new DataNotFoundException("dept no " + deptNo));
    }

    @Override
    public List<DepartmentsEntity> findAll() {
        return departmentsRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public void create(DepartmentsEntity data) {

        if (departmentsRepository.findById(data.getDeptNo()).isPresent()) {
            throw new AlreadyExistException("dept no " + data.getDeptNo());
        }

        departmentsRepository.save(data);
    }

    @Override
    public void update(DepartmentsEntity data) {
        findById(data.getDeptNo());
        departmentsRepository.save(data);
    }

    @Override
    public void delete(String deptNo) {
        findById(deptNo);
        departmentsRepository.deleteById(deptNo);
    }

}
