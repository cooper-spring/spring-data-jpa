package com.cooper.springdatajpa.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LookupEmployeeSalaryResponseDTO {

    private final Long empNo;

    private final String title;

    private final Long salary;

}
