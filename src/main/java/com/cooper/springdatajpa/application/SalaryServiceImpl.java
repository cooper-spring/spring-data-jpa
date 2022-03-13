package com.cooper.springdatajpa.application;

import com.cooper.springdatajpa.domain.SalaryRepository;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    @Override
    public List<LookupEmployeeSalaryResponseDTO> findAllSalaries() {
        return salaryRepository.findAllTitleSalaries();
    }

}