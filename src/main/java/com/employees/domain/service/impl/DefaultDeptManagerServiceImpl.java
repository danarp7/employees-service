package com.employees.domain.service.impl;

import com.employees.domain.exceptions.AlreadyExistException;
import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.DeptManagerRepository;
import com.employees.domain.service.DepartmentsService;
import com.employees.domain.service.DeptManagerService;
import com.employees.domain.service.EmployeesService;
import com.employees.infrastructure.repository.mysql.entity.*;
import com.employees.interfaces.web.dto.DeptEmpRequestDto;
import com.employees.interfaces.web.dto.DeptManagerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultDeptManagerServiceImpl implements DeptManagerService {

    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private EmployeesService employeesService;

    @Override
    public DeptManagerEntity findById(String deptNo, Integer empNo) {
        EmployeesEntity employeesEntity = employeesService.findById(empNo);
        DepartmentsEntity departmentsEntity = departmentsService.findById(deptNo);

        return deptManagerRepository.findById(new DeptManagerId(departmentsEntity, employeesEntity))
                .orElseThrow(() -> new DataNotFoundException("dept no " + deptNo + ", emp no " + empNo));
    }

    @Override
    public List<DeptManagerEntity> findAll() {
        return deptManagerRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public void create(DeptManagerRequestDto data) {
        EmployeesEntity employeesEntity = employeesService.findById(data.getEmpNo());
        DepartmentsEntity departmentsEntity = departmentsService.findById(data.getDeptNo());

        DeptManagerId deptManagerId = new DeptManagerId(departmentsEntity, employeesEntity);

        if (deptManagerRepository.findById(deptManagerId).isPresent()) {
            throw new AlreadyExistException("dept no " + data.getDeptNo() + ", emp no " + data.getEmpNo());
        }

        DeptManagerEntity entity = new DeptManagerEntity(deptManagerId, data.getFromDate(), data.getToDate());

        deptManagerRepository.save(entity);
    }

    @Override
    public void update(DeptManagerRequestDto data) {
        DeptManagerEntity entity = findById(data.getDeptNo(), data.getEmpNo());

        DeptManagerEntity updateEntity = new DeptManagerEntity(entity.getDeptManagerId(), data.getFromDate(),
                data.getToDate());

        deptManagerRepository.save(updateEntity);
    }

    @Override
    public void delete(String deptNo, Integer empNo) {
        DeptManagerEntity entity = findById(deptNo, empNo);
        deptManagerRepository.deleteById(entity.getDeptManagerId());
    }

}
