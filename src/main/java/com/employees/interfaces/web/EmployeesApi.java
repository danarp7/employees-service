package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.EmployeesEntity;
import com.employees.interfaces.web.dto.EmployeesRequestDto;
import com.employees.interfaces.web.dto.EmployeesRequestUpdateDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "employees", description = "Operations about employees")
@RequestMapping("/api/v1/employees")
public interface EmployeesApi {

    @Operation(summary = "Register new employees")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody EmployeesRequestDto request);

    @Operation(summary = "Update employees")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody EmployeesRequestUpdateDto request);

    @Operation(summary = "Delete employees by id")
    @DeleteMapping("/{empNo}")
    ResponseEntity<EmployeesResponse> delete(@PathVariable Integer empNo);

    @Operation(summary = "Get all employees")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<EmployeesEntity>>> getAll();

    @Operation(summary = "Get employees by id")
    @GetMapping("/{empNo}")
    ResponseEntity<EmployeesResponse<EmployeesEntity>> getById(@PathVariable Integer empNo);

}
