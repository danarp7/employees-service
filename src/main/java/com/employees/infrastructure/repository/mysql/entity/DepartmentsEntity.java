package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "departments",
        uniqueConstraints = {@UniqueConstraint(name = "departments_dept_name_unq",
                columnNames = {"dept_name"})}
                )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsEntity implements Serializable {

    private static final long serialVersionUID = -7200302743133006150L;

    @Id
    @Column(name = "dept_no", length = 4)
    @NotBlank(message = "deptNo is mandatory")
    @Size(max = 4, message = "maximum 4 character")
    private String deptNo;

    @Column(name = "dept_name", length = 40, nullable = false)
    @NotBlank(message = "deptName is mandatory")
    @Size(max = 40, message = "maximum 40 character")
    private String deptName;

}
