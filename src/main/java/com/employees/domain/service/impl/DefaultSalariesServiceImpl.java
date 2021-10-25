package com.employees.domain.service.impl;

import com.employees.domain.exceptions.AlreadyExistException;
import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.SalariesRepository;
import com.employees.domain.service.EmployeesService;
import com.employees.domain.service.SalariesService;
import com.employees.infrastructure.repository.mysql.entity.*;
import com.employees.interfaces.web.dto.SalariesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultSalariesServiceImpl implements SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;

    @Autowired
    private EmployeesService employeesService;

    @Override
    public SalariesEntity findById(Integer empNo, Date fromDate) {
        EmployeesEntity employeesEntity = employeesService.findById(empNo);

        return salariesRepository.findById(new SalariesId(employeesEntity, fromDate))
                .orElseThrow(() -> new DataNotFoundException("emp no " + empNo + ", from date " + fromDate));
    }

    @Override
    public List<SalariesEntity> findAll() {
        return salariesRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public List<SalariesEntity> findByEmpNo(Integer empNo) {
        employeesService.findById(empNo);
        return salariesRepository.findByEmpNo(empNo)
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public void create(SalariesRequestDto data) {
        EmployeesEntity employeesEntity = employeesService.findById(data.getEmpNo());

        SalariesId salariesId = new SalariesId(employeesEntity, data.getFromDate());

        if (salariesRepository.findById(salariesId).isPresent()) {
            throw new AlreadyExistException("emp no " + data.getEmpNo() + ", from date " + data.getFromDate());
        }

        SalariesEntity entity = new SalariesEntity(salariesId, data.getSalary(), data.getToDate());

        salariesRepository.save(entity);
    }

    @Override
    public void update(SalariesRequestDto data) {
        SalariesEntity entity = findById(data.getEmpNo(), data.getFromDate());

        SalariesEntity updateEntity = new SalariesEntity(entity.getSalariesId(), data.getSalary(), data.getToDate());

        salariesRepository.save(updateEntity);
    }

    @Override
    public void delete(Integer empNo, Date fromDate) {
        SalariesEntity entity = findById(empNo, fromDate);
        salariesRepository.deleteById(entity.getSalariesId());
    }

}
