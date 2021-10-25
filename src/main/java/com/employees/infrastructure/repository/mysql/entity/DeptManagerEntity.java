package com.employees.infrastructure.repository.mysql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dept_manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptManagerEntity implements Serializable {

    private static final long serialVersionUID = -7008317590882761593L;

    @EmbeddedId
    private DeptManagerId deptManagerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    @NotNull(message = "fromDate is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

}
