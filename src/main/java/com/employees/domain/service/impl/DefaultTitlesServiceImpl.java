package com.employees.domain.service.impl;

import com.employees.domain.exceptions.AlreadyExistException;
import com.employees.domain.exceptions.DataNotFoundException;
import com.employees.domain.repository.TitlesRepository;
import com.employees.domain.service.EmployeesService;
import com.employees.domain.service.TitlesService;
import com.employees.infrastructure.repository.mysql.entity.*;
import com.employees.interfaces.web.dto.TitlesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultTitlesServiceImpl implements TitlesService {

    @Autowired
    private TitlesRepository titlesRepository;

    @Autowired
    private EmployeesService employeesService;

    @Override
    public TitlesEntity findById(Integer empNo, String title, Date fromDate) {
        EmployeesEntity employeesEntity = employeesService.findById(empNo);

        return titlesRepository.findById(new TitlesId(employeesEntity, title, fromDate))
                .orElseThrow(() -> new DataNotFoundException("emp no " + empNo + ", title " + title
                        + ", from date " + fromDate));
    }

    @Override
    public List<TitlesEntity> findAll() {
        return titlesRepository.findAll()
                .orElseThrow(() -> new DataNotFoundException("database is empty"));
    }

    @Override
    public List<TitlesEntity> findByEmpNo(Integer empNo) {
        employeesService.findById(empNo);
        return titlesRepository.findByEmpNo(empNo)
                .orElseThrow(() -> new DataNotFoundException("emp no " + empNo));
    }

    @Override
    public void create(TitlesRequestDto data) {
        EmployeesEntity employeesEntity = employeesService.findById(data.getEmpNo());

        TitlesId titlesId = new TitlesId(employeesEntity, data.getTitle(), data.getFromDate());

        if (titlesRepository.findById(titlesId).isPresent()) {
            throw new AlreadyExistException("emp no " + data.getEmpNo() + ", title " + data.getTitle()
                    + ", from date " + data.getFromDate());
        }

        TitlesEntity entity = new TitlesEntity(titlesId, data.getToDate());

        titlesRepository.save(entity);
    }

    @Override
    public void update(TitlesRequestDto data) {
        TitlesEntity entity = findById(data.getEmpNo(), data.getTitle(), data.getFromDate());

        TitlesEntity updateEntity = new TitlesEntity(entity.getTitlesId(), data.getToDate());

        titlesRepository.save(updateEntity);
    }

    @Override
    public void delete(Integer empNo, String title, Date fromDate) {
        TitlesEntity entity = findById(empNo, title, fromDate);
        titlesRepository.deleteById(entity.getTitlesId());
    }

}
