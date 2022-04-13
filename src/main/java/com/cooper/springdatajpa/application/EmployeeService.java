package com.cooper.springdatajpa.application;

import com.cooper.springdatajpa.dto.ExistEmployeeResponseDTO;
import com.cooper.springdatajpa.dto.LookupEmployeeResponseDTO;

public interface EmployeeService {

    LookupEmployeeResponseDTO findById(Long id);

    ExistEmployeeResponseDTO exists(Long employeeId);
}
