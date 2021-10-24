package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dept_emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpEntity implements Serializable {

    private static final long serialVersionUID = -7734239045970627582L;

    @EmbeddedId
    private DeptEmpId deptEmpId;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    @NotNull(message = "fromDate is mandatory")
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date toDate;

}
