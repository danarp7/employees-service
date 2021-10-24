package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.SalariesEntity;
import com.employees.interfaces.web.dto.EmployeesResponse;
import com.employees.interfaces.web.dto.SalariesRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Tag(name = "salaries", description = "Operations about salaries")
@RequestMapping("/api/v1/salaries")
public interface SalariesApi {

    @Operation(summary = "Register new salaries")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody SalariesRequestDto request);

    @Operation(summary = "Update salaries")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody SalariesRequestDto request);

    @Operation(summary = "Delete salaries by id")
    @DeleteMapping("/employees/{empNo}/fromDate/{fromDate}")
    ResponseEntity<EmployeesResponse> delete(
            @PathVariable Integer empNo, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate);

    @Operation(summary = "Get all salaries")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<SalariesEntity>>> getAll();

    @Operation(summary = "Get salaries by id")
    @GetMapping("/employees/{empNo}/fromDate/{fromDate}")
    ResponseEntity<EmployeesResponse<SalariesEntity>> getById(
            @PathVariable Integer empNo, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate);

}
