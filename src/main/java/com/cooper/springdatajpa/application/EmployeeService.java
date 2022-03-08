package com.cooper.springdatajpa.application;

import com.cooper.springdatajpa.dto.LookupEmployeeResponseDTO;

public interface EmployeeService {

    LookupEmployeeResponseDTO findById(Long id);

}
