package com.employees.domain.service.impl;

import com.employees.domain.exceptions.AlreadyExistException;
import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.DepartmentsRepository;
import com.employees.domain.repository.DeptEmpRepository;
import com.employees.domain.repository.EmployeesRepository;
import com.employees.domain.service.DepartmentsService;
import com.employees.domain.service.DeptEmpService;
import com.employees.domain.service.EmployeesService;
import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpId;
import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import com.employees.interfaces.web.dto.DeptEmpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultDeptEmpServiceImpl implements DeptEmpService {

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private EmployeesService employeesService;

    @Override
    public DeptEmpEntity findById(Integer empNo, String deptNo) {
        EmployeesEntity employeesEntity = employeesService.findById(empNo);
        DepartmentsEntity departmentsEntity = departmentsService.findById(deptNo);

        return deptEmpRepository.findById(new DeptEmpId(employeesEntity, departmentsEntity))
                .orElseThrow(() -> new DataNotFoundException("emp no " + empNo + ", dept no " + deptNo));
    }

    @Override
    public List<DeptEmpEntity> findAll() {
        return deptEmpRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public void create(DeptEmpRequestDto data) {
        EmployeesEntity employeesEntity = employeesService.findById(data.getEmpNo());
        DepartmentsEntity departmentsEntity = departmentsService.findById(data.getDeptNo());

        DeptEmpId deptEmpId = new DeptEmpId(employeesEntity, departmentsEntity);

        if (deptEmpRepository.findById(deptEmpId).isPresent()) {
            throw new AlreadyExistException("emp no " + data.getEmpNo() + ", dept no " + data.getDeptNo());
        }

        DeptEmpEntity entity = new DeptEmpEntity(deptEmpId, data.getFromDate(), data.getToDate());

        deptEmpRepository.save(entity);
    }

    @Override
    public void update(DeptEmpRequestDto data) {
        DeptEmpEntity entity = findById(data.getEmpNo(), data.getDeptNo());

        DeptEmpEntity updateEntity = new DeptEmpEntity(entity.getDeptEmpId(), data.getFromDate(), data.getToDate());

        deptEmpRepository.save(updateEntity);
    }

    @Override
    public void delete(Integer empNo, String deptNo) {
        DeptEmpEntity entity = findById(empNo, deptNo);
        deptEmpRepository.deleteById(entity.getDeptEmpId());
    }

}
