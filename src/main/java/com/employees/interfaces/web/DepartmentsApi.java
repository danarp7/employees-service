package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.DepartmentsEntity;
import com.employees.interfaces.web.dto.DepartmentsRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "departments", description = "Operations about departments")
@RequestMapping("/api/v1/departments")
public interface DepartmentsApi {

    @Operation(summary = "Register new departments")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody DepartmentsRequestDto request);

    @Operation(summary = "Update departments")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody DepartmentsRequestDto request);

    @Operation(summary = "Delete departments by id")
    @DeleteMapping("/{deptNo}")
    ResponseEntity<EmployeesResponse> delete(@PathVariable String deptNo);

    @Operation(summary = "Get all departments")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<DepartmentsEntity>>> getAll();

    @Operation(summary = "Get departments by id")
    @GetMapping("/{deptNo}")
    ResponseEntity<EmployeesResponse<DepartmentsEntity>> getById(@PathVariable String deptNo);

}
