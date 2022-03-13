package com.cooper.springdatajpa.domain;

import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;

import java.util.List;

public interface SalaryRepository {

    List<LookupEmployeeSalaryResponseDTO> findAllTitleSalaries();

    List<LookupEmployeeSalaryResponseDTO> findSalariesByPaging(int pageNo);

}
