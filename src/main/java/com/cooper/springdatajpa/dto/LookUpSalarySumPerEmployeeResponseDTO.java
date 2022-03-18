package com.cooper.springdatajpa.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LookUpSalarySumPerEmployeeResponseDTO {

    private final String name;

    private final Long sumOfSalaries;

}
