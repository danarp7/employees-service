package com.employees.infrastructure.repository.mysql;

import com.employees.infrastructure.repository.mysql.entity.TitlesEntity;
import com.employees.infrastructure.repository.mysql.entity.TitlesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTitlesRepository extends JpaRepository<TitlesEntity, TitlesId> {
}
