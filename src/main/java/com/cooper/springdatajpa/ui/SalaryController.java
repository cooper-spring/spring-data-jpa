package com.cooper.springdatajpa.ui;

import com.cooper.springdatajpa.application.SalaryService;
import com.cooper.springdatajpa.dto.LookUpSalarySumPerEmployeeResponseDTO;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 2. query dsl pagination
     * - query dsl을 사용할 경우, pageable을 사용하기 보다는 offset, limit를 사용하도록 하자.
     */
    @GetMapping("/{pageNo}")
    public ResponseEntity<List<LookupEmployeeSalaryResponseDTO>> getSalaries (@PathVariable int pageNo) {
        List<LookupEmployeeSalaryResponseDTO> salaryResponseDTOList = salaryService.findSalariesByPaging(pageNo);
        return ResponseEntity.ok(salaryResponseDTOList);
    }

    @GetMapping("/covering/{pageNo}")
    public ResponseEntity<List<LookupEmployeeSalaryResponseDTO>> getSalariesByCovering(@PathVariable int pageNo) {
        List<LookupEmployeeSalaryResponseDTO> salaryResponseDTOList = salaryService.findSalariesByCoveringIndex(pageNo);
        return ResponseEntity.ok(salaryResponseDTOList);
    }

    @GetMapping("/sum/employees/all")
    public ResponseEntity<List<LookUpSalarySumPerEmployeeResponseDTO>> getSumOfSalariesPerEmployee() {
        List<LookUpSalarySumPerEmployeeResponseDTO> lookUpSalarySumPerEmployeeResponseDTOList
                = salaryService.getSumOfSalariesPerEmployee();
        return ResponseEntity.ok(lookUpSalarySumPerEmployeeResponseDTOList);
    }
}
