package com.cooper.springdatajpa.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class LookupEmployeeSalaryResponseDTO {

    private final Long empNo;

    private final String title;

    private final Long salary;

    @QueryProjection
    public LookupEmployeeSalaryResponseDTO(Long empNo, String title, Long salary) {
        this.empNo = empNo;
        this.title = title;
        this.salary = salary;
    }

}
