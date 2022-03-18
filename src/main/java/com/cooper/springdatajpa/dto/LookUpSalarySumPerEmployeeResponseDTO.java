package com.cooper.springdatajpa.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LookUpSalarySumPerEmployeeResponseDTO {

    private final String lastName;

    private final String title;

    private final Long sumOfSalaries;

}
