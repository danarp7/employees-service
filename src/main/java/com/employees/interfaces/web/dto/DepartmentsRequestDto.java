package com.employees.interfaces.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsRequestDto {

    @NotBlank(message = "deptNo is mandatory")
    @Size(max = 4, message = "maximum 4 character")
    private String deptNo;

    @NotBlank(message = "deptName is mandatory")
    @Size(max = 40, message = "maximum 40 character")
    private String deptName;

}
