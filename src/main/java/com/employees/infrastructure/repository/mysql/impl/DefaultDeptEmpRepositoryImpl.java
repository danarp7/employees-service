package com.employees.infrastructure.repository.mysql.impl;

import com.employees.domain.repository.DeptEmpRepository;
import com.employees.infrastructure.repository.mysql.SpringDataDeptEmpRepository;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultDeptEmpRepositoryImpl implements DeptEmpRepository {

    @Autowired
    private SpringDataDeptEmpRepository repository;

    @Override
    public Optional<List<DeptEmpEntity>> findAll() {
        List<DeptEmpEntity> data = repository.findAll();

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<DeptEmpEntity> findById(DeptEmpId deptEmpId) {
        return repository.findById(deptEmpId);
    }

    @Override
    public Optional<List<DeptEmpEntity>> findByEmpNo(Integer empNo) {
        List<DeptEmpEntity> data = repository.findByDeptEmpIdEmployeesEntityEmpNo(empNo);

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public Optional<List<DeptEmpEntity>> findByDeptNo(String deptNo) {
        List<DeptEmpEntity> data = repository.findByDeptEmpIdDepartmentsEntityDeptNo(deptNo);

        if (data.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(data);
    }

    @Override
    public void save(DeptEmpEntity data) {
        repository.save(data);
    }

    @Override
    public void deleteById(DeptEmpId deptEmpId) {
        repository.deleteById(deptEmpId);
    }

}
