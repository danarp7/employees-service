package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptManagerId implements Serializable {

    private static final long serialVersionUID = 1019532370091879765L;

    @ManyToOne
    @JoinColumn(name = "dept_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DepartmentsEntity departmentsEntity;

    @ManyToOne
    @JoinColumn(name = "emp_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeesEntity employeesEntity;

}
