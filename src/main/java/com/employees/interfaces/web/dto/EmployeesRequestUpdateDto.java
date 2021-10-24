package com.employees.interfaces.web.dto;

import com.employees.domain.model.value.EmployeesGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesRequestUpdateDto {

    @NotNull(message = "empNo is mandatory")
    private Integer empNo;

    @NotNull(message = "birthDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotBlank(message = "firstName is mandatory")
    @Size(max = 14, message = "maximum 14 character")
    private String firstName;

    @Size(max = 16, message = "maximum 16 character")
    private String lastName;

    @NotNull(message = "gender is mandatory")
    private EmployeesGender gender;

    @NotNull(message = "hireDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
