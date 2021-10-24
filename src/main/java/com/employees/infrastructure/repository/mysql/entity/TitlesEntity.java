package com.employees.infrastructure.repository.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "titles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitlesEntity implements Serializable {

    private static final long serialVersionUID = 7534869261283646998L;

    @EmbeddedId
    private TitlesId titlesId;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date")
    private Date toDate;

}
