package com.cooper.springdatajpa.dto;

import lombok.Getter;

@Getter
public class LookupEmployeeSalaryResponseDTO {

    private final Long empNo;

    private final String title;

    private final Long salary;

    public LookupEmployeeSalaryResponseDTO(Long empNo, String title, Long salary) {
        this.empNo = empNo;
        this.title = title;
        this.salary = salary;
    }

}
