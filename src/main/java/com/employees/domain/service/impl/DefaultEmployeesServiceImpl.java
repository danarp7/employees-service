package com.employees.domain.service.impl;

import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.EmployeesRepository;
import com.employees.domain.service.EmployeesService;
import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public EmployeesEntity findById(Integer empNo) {
        return employeesRepository.findById(empNo)
                .orElseThrow(() -> new DataNotFoundException("emp no " + empNo));
    }

    @Override
    public List<EmployeesEntity> findAll() {
        return employeesRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public void create(EmployeesEntity data) {
        employeesRepository.save(data);
    }

    @Override
    public void update(EmployeesEntity data) {
        findById(data.getEmpNo());
        employeesRepository.save(data);
    }

    @Override
    public void delete(Integer empNo) {
        findById(empNo);
        employeesRepository.deleteById(empNo);
    }

}
