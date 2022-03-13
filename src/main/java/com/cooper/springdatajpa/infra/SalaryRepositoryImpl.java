package com.cooper.springdatajpa.infra;

import com.cooper.springdatajpa.domain.SalaryRepository;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;
import com.cooper.springdatajpa.dto.QLookupEmployeeSalaryResponseDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.cooper.springdatajpa.domain.QEmployee.employee;
import static com.cooper.springdatajpa.domain.QSalary.salary;
import static com.cooper.springdatajpa.domain.QTitle.title;

@Repository
@RequiredArgsConstructor
public class SalaryRepositoryImpl implements SalaryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<LookupEmployeeSalaryResponseDTO> findAllTitleSalaries() {
        return jpaQueryFactory.query()
                .select(Projections.fields(LookupEmployeeSalaryResponseDTO.class,
                        employee.id,
                        title.titleId.title,
                        salary.amount
                ))
                .from(salary)
                .innerJoin(employee).on(salary.salaryId.empNo.eq(employee.id))
                .innerJoin(title).on(employee.id.eq(title.titleId.empNo))
                .fetch();
    }

}
