package com.employees.interfaces.web.controller;

import com.employees.domain.service.DepartmentsService;
import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import com.employees.interfaces.web.DepartmentsApi;
import com.employees.interfaces.web.dto.DepartmentsRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentsController implements DepartmentsApi {

    @Autowired
    private DepartmentsService departmentsService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<EmployeesResponse> create(DepartmentsRequestDto request) {

        DepartmentsEntity data = modelMapper.map(request, DepartmentsEntity.class);

        departmentsService.create(data);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(DepartmentsRequestDto request) {

        DepartmentsEntity data = modelMapper.map(request, DepartmentsEntity.class);

        departmentsService.update(data);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(String deptNo) {

        departmentsService.delete(deptNo);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<DepartmentsEntity>>> getAll() {

        List<DepartmentsEntity> data = departmentsService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<DepartmentsEntity>> getById(String deptNo) {

        DepartmentsEntity data = departmentsService.findById(deptNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
