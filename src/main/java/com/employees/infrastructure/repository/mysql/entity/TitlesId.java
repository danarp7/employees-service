package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitlesId implements Serializable {

    private static final long serialVersionUID = 7020422377059056733L;

    @ManyToOne
    @JoinColumn(name = "emp_no")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployeesEntity employeesEntity;

    @Column(name = "title", length = 50)
    @NotBlank(message = "title is mandatory")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date")
    @NotNull(message = "fromDate is mandatory")
    private Date fromDate;
}
