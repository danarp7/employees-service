package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalariesEntity implements Serializable {

    private static final long serialVersionUID = 8418399096964340180L;

    @EmbeddedId
    private SalariesId salariesId;

    @Column(name = "salary", nullable = false)
    @NotNull(message = "salary is mandatory")
    private Integer salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date toDate;

}
