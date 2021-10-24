package com.employees.interfaces.web.controller;

import com.employees.domain.service.SalariesService;
import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.interfaces.web.SalariesApi;
import com.employees.interfaces.web.dto.EmployeesResponse;
import com.employees.interfaces.web.dto.SalariesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SalariesController implements SalariesApi {

    @Autowired
    private SalariesService salariesService;

    @Override
    public ResponseEntity<EmployeesResponse> create(SalariesRequestDto request) {

        salariesService.create(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(SalariesRequestDto request) {

        salariesService.update(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(Integer empNo, Date fromDate) {

        salariesService.delete(empNo, fromDate);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<SalariesEntity>>> getAll() {

        List<SalariesEntity> data = salariesService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Override
    public ResponseEntity<EmployeesResponse<SalariesEntity>> getById(Integer empNo, Date fromDate) {

        SalariesEntity data = salariesService.findById(empNo, fromDate);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
