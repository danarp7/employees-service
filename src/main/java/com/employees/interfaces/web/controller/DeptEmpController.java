package com.employees.interfaces.web.controller;

import com.employees.domain.service.DeptEmpService;
import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.interfaces.web.DeptEmpApi;
import com.employees.interfaces.web.dto.DeptEmpRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptEmpController implements DeptEmpApi {

    @Autowired
    private DeptEmpService deptEmpService;

    @Override
    public ResponseEntity<EmployeesResponse> create(DeptEmpRequestDto request) {

        deptEmpService.create(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(DeptEmpRequestDto request) {

        deptEmpService.update(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(Integer empNo, String deptNo) {

        deptEmpService.delete(empNo, deptNo);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptEmpEntity>>> getAll() {

        List<DeptEmpEntity> data = deptEmpService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Override
    public ResponseEntity<EmployeesResponse<DeptEmpEntity>> getById(Integer empNo, String deptNo) {

        DeptEmpEntity data = deptEmpService.findById(empNo, deptNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptEmpEntity>>> getByEmpNo(Integer empNo) {

        List<DeptEmpEntity> data = deptEmpService.findByEmpNo(empNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptEmpEntity>>> getByDeptNo(String deptNo) {

        List<DeptEmpEntity> data = deptEmpService.findByDeptNo(deptNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
