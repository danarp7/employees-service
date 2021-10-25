package com.employees.interfaces.web.controller;

import com.employees.domain.model.value.EmployeesGender;
import com.employees.domain.service.EmployeesService;
import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import com.employees.interfaces.web.EmployeesApi;
import com.employees.interfaces.web.dto.EmployeesRequestDto;
import com.employees.interfaces.web.dto.EmployeesRequestUpdateDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController implements EmployeesApi {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<EmployeesResponse> create(EmployeesRequestDto request) {

        EmployeesGender.of(request.getGender().name());

        EmployeesEntity data = modelMapper.map(request, EmployeesEntity.class);

        employeesService.create(data);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(EmployeesRequestUpdateDto request) {

        EmployeesGender.of(request.getGender().name());

        EmployeesEntity data = modelMapper.map(request, EmployeesEntity.class);

        employeesService.update(data);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(Integer empNo) {

        employeesService.delete(empNo);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<EmployeesEntity>>> getAll() {

        List<EmployeesEntity> data = employeesService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<EmployeesEntity>> getById(Integer empNo) {

        EmployeesEntity data = employeesService.findById(empNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
