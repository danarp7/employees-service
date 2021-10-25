package com.employees.interfaces.web.controller;

import com.employees.domain.service.DeptManagerService;
import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.interfaces.web.DeptManagerApi;
import com.employees.interfaces.web.dto.DeptManagerRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptManagerController implements DeptManagerApi {

    @Autowired
    private DeptManagerService deptManagerService;

    @Override
    public ResponseEntity<EmployeesResponse> create(DeptManagerRequestDto request) {

        deptManagerService.create(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(DeptManagerRequestDto request) {

        deptManagerService.update(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(String deptNo, Integer empNo) {

        deptManagerService.delete(deptNo, empNo);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptManagerEntity>>> getAll() {

        List<DeptManagerEntity> data = deptManagerService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Override
    public ResponseEntity<EmployeesResponse<DeptManagerEntity>> getById(String deptNo, Integer empNo) {

        DeptManagerEntity data = deptManagerService.findById(deptNo, empNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptManagerEntity>>> getByEmpNo(Integer empNo) {

        List<DeptManagerEntity> data = deptManagerService.findByEmpNo(empNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DeptManagerEntity>>> getByDeptNo(String deptNo) {

        List<DeptManagerEntity> data = deptManagerService.findByDeptNo(deptNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
