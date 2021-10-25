package com.employees.interfaces.web.controller;

import com.employees.domain.service.TitlesService;
import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.interfaces.web.TItlesApi;
import com.employees.interfaces.web.dto.EmployeesResponse;
import com.employees.interfaces.web.dto.TitlesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TitlesController implements TItlesApi {

    @Autowired
    private TitlesService titlesService;

    @Override
    public ResponseEntity<EmployeesResponse> create(TitlesRequestDto request) {

        titlesService.create(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> update(TitlesRequestDto request) {

        titlesService.update(request);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse> delete(Integer empNo, String title, Date fromDate) {

        titlesService.delete(empNo, title, fromDate);

        EmployeesResponse response = EmployeesResponse.success(null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<TitlesEntity>>> getAll() {

        List<TitlesEntity> data = titlesService.findAll();

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @Override
    public ResponseEntity<EmployeesResponse<TitlesEntity>> getById(Integer empNo, String title, Date fromDate) {

        TitlesEntity data = titlesService.findById(empNo, title, fromDate);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<EmployeesResponse<List<TitlesEntity>>> getByEmpNo(Integer empNo) {

        List<TitlesEntity> data = titlesService.findByEmpNo(empNo);

        EmployeesResponse response = EmployeesResponse.success(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
