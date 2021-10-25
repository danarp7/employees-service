package com.employees.interfaces.web;

import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.interfaces.web.dto.EmployeesResponse;
import com.employees.interfaces.web.dto.TitlesRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Tag(name = "titles", description = "Operations about titles")
@RequestMapping("/api/v1/titles")
public interface TItlesApi {

    @Operation(summary = "Register new titles")
    @PostMapping
    ResponseEntity<EmployeesResponse> create(@Valid @RequestBody TitlesRequestDto request);

    @Operation(summary = "Update titles")
    @PutMapping
    ResponseEntity<EmployeesResponse> update(@Valid @RequestBody TitlesRequestDto request);

    @Operation(summary = "Delete titles by id")
    @DeleteMapping("/employees/{empNo}/title/{title}/fromDate/{fromDate}")
    ResponseEntity<EmployeesResponse> delete(
            @PathVariable Integer empNo, @PathVariable String title,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate);

    @Operation(summary = "Get all titles")
    @GetMapping
    ResponseEntity<EmployeesResponse<List<TitlesEntity>>> getAll();

    @Operation(summary = "Get titles by id")
    @GetMapping("/employees/{empNo}/title/{title}/fromDate/{fromDate}")
    ResponseEntity<EmployeesResponse<TitlesEntity>> getById(
            @PathVariable Integer empNo, @PathVariable String title,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate);

    @Operation(summary = "Get titles by emp no")
    @GetMapping("/employees/{empNo}")
    ResponseEntity<EmployeesResponse<List<TitlesEntity>>> getByEmpNo(@PathVariable Integer empNo);

}
