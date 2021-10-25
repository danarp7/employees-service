package com.employees.infrastructure.repository.mysql.entity;

import com.employees.domain.model.value.EmployeesGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesEntity implements Serializable {

    private static final long serialVersionUID = -134442075468957496L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private Integer empNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    @NotNull(message = "birthDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "first_name", length = 14, nullable = false)
    @NotBlank(message = "firstName is mandatory")
    @Size(max = 14, message = "maximum 14 character")
    private String firstName;

    @Column(name = "last_name", length = 16)
    @Size(max = 16, message = "maximum 16 character")
    private String lastName;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "gender is mandatory")
    private EmployeesGender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    @NotNull(message = "hireDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
