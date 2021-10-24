package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.DeptManagerEntity;
import com.employees.interfaces.web.dto.DeptManagerRequestDto;
import com.employees.interfaces.web.dto.EmployeesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "dept manager", description = "Operations about dept manager")
@RequestMapping("/api/v1/deptManager")
public interface DeptManagerApi {

    @Operation(summary = "Register new dept manager")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody DeptManagerRequestDto request);

    @Operation(summary = "Update dept manager")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody DeptManagerRequestDto request);

    @Operation(summary = "Delete dept manager by id")
    @DeleteMapping("/departments/{deptNo}/employees/{empNo}")
    ResponseEntity<EmployeesResponse> delete(@PathVariable String deptNo, @PathVariable Integer empNo);

    @Operation(summary = "Get all dept manager")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<DeptManagerEntity>>> getAll();

    @Operation(summary = "Get dept manager by id")
    @GetMapping("/departments/{deptNo}/employees/{empNo}")
    ResponseEntity<EmployeesResponse<DeptManagerEntity>> getById(
            @PathVariable String deptNo, @PathVariable Integer empNo);

}
