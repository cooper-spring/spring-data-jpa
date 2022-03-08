package com.cooper.springdatajpa.dto;

import com.cooper.springdatajpa.domain.Employee;
import com.cooper.springdatajpa.domain.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class LookupEmployeeResponseDTO {

    private final Long id;

    private final LocalDate birthDate;

    private final String firstName;

    private final String lastName;

    private final Gender gender;

    private final LocalDate hireDate;

    public static LookupEmployeeResponseDTO fromEntity(Employee employee) {
        return LookupEmployeeResponseDTO.builder()
                .id(employee.getId())
                .birthDate(employee.getBirthDate())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .gender(employee.getGender())
                .hireDate(employee.getHireDate())
                .build();
    }

}

