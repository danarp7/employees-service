package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpId implements Serializable {

    private static final long serialVersionUID = -2248691188262354402L;

    @ManyToOne
    @JoinColumn(name = "emp_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeesEntity employeesEntity;

    @ManyToOne
    @JoinColumn(name = "dept_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DepartmentsEntity departmentsEntity;

}
