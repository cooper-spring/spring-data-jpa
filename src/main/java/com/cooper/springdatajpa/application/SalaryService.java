package com.cooper.springdatajpa.application;

import com.cooper.springdatajpa.dto.LookUpSalarySumPerEmployeeResponseDTO;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;

import java.util.List;

public interface SalaryService {

    List<LookupEmployeeSalaryResponseDTO> findAllSalaries();

    List<LookupEmployeeSalaryResponseDTO> findSalariesByPaging(int pageNo);

    List<LookupEmployeeSalaryResponseDTO> findSalariesByCoveringIndex(int pageNo);

    List<LookUpSalarySumPerEmployeeResponseDTO> getSumOfSalariesPerEmployee(int pageNo);

}
