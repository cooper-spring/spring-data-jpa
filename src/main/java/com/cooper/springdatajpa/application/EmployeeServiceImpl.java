package com.cooper.springdatajpa.application;

import com.cooper.springdatajpa.constants.ErrorMessageConstants;
import com.cooper.springdatajpa.domain.Employee;
import com.cooper.springdatajpa.domain.EmployeeRepository;
import com.cooper.springdatajpa.dto.LookupEmployeeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public LookupEmployeeResponseDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessageConstants.WRONG_EMPLOYEE_ID));
        return LookupEmployeeResponseDTO.fromEntity(employee);
    }

}
