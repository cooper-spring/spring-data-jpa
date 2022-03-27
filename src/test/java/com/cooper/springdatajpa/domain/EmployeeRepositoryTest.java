package com.cooper.springdatajpa.domain;

import com.cooper.springdatajpa.config.QueryDslConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Import(QueryDslConfig.class)
@DataJpaTest(
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE, classes = EmployeeRepository.class
        )
)
// 같은 local db와 test db를 사용할 경우 default value = h2
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DisplayName("사원 조회 테스트")
    void shouldReturnSingleEmployeeById() {
        //given
        Employee employee = new Employee(
                LocalDate.of(2000, 1, 1),
                "firstName",
                "lastName",
                Gender.M,
                LocalDate.of(2022, 3, 27)
        );

        Employee persistedEmployee = testEntityManager.persist(employee);

        //when
        Employee savedEmployee = employeeRepository.findById(persistedEmployee.getId()).orElseThrow();

        //then
        assertThat(persistedEmployee.getId()).isEqualTo(savedEmployee.getId());
    }
}