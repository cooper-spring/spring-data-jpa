package com.cooper.springdatajpa.ui;

import com.cooper.springdatajpa.application.SalaryService;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salaries")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    /**
     * 1. query dsl을 이용한 사원 번호, 부서, 월급 반환
     */
    @GetMapping
    public ResponseEntity<List<LookupEmployeeSalaryResponseDTO>> getSalaries() {
        List<LookupEmployeeSalaryResponseDTO> allSalariesPerTitle = salaryService.findAllSalaries();
        return ResponseEntity.ok(allSalariesPerTitle);
    }
}
