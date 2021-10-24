package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.DeptEmpEntity;
import com.employees.interfaces.web.dto.DeptEmpRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "dept emp", description = "Operations about dept emp")
@RequestMapping("/api/v1/deptEmp")
public interface DeptEmpApi {

    @Operation(summary = "Register new dept emp")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody DeptEmpRequestDto request);

    @Operation(summary = "Update dept emp")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody DeptEmpRequestDto request);

    @Operation(summary = "Delete dept emp by id")
    @DeleteMapping("/employees/{empNo}/departments/{deptNo}")
    ResponseEntity<EmployeesResponse> delete(@PathVariable Integer empNo, @PathVariable String deptNo);

    @Operation(summary = "Get all dept emp")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<DeptEmpEntity>>> getAll();

    @Operation(summary = "Get dept emp by id")
    @GetMapping("/employees/{empNo}/departments/{deptNo}")
    ResponseEntity<EmployeesResponse<DeptEmpEntity>> getById(@PathVariable Integer empNo, @PathVariable String deptNo);

}
