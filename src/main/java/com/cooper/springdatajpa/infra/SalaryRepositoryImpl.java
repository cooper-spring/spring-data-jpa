package com.cooper.springdatajpa.infra;

import com.cooper.springdatajpa.domain.SalaryId;
import com.cooper.springdatajpa.domain.SalaryRepository;
import com.cooper.springdatajpa.dto.LookUpSalarySumPerEmployeeResponseDTO;
import com.cooper.springdatajpa.dto.LookupEmployeeSalaryResponseDTO;
import com.querydsl.core.types.Projections;
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
                .select(Projections.constructor(LookupEmployeeSalaryResponseDTO.class,
                        employee.id.as("empNo"),
                        title.titleId.title,
                        salary.amount.as("salary")
                ))
                .from(salary)
                .innerJoin(employee).on(salary.salaryId.empNo.eq(employee.id))
                .innerJoin(title).on(employee.id.eq(title.titleId.empNo))
                .fetch();
    }

    /**
     * 2. join 사용 시, 명시적 조인을 사용하도록 하자.
     * - 묵시적 조인을 선언했을 경우, cross join 이 발생할 위험이 있어 성능상 문제가 발생할 수 있다.
     */
    @Override
    public List<LookupEmployeeSalaryResponseDTO> findSalariesByPaging(int pageNo) {
        return jpaQueryFactory.query()
                .select(Projections.constructor(LookupEmployeeSalaryResponseDTO.class,
                        employee.id.as("empNo"),
                        title.titleId.title,
                        salary.amount.as("salary")
                )).from(salary)
                .innerJoin(employee).on(salary.salaryId.empNo.eq(employee.id))
                .innerJoin(title).on(employee.id.eq(title.titleId.empNo))
                .offset(pageNo)
                .limit(10)
                .fetch();
    }

    @Override
    public List<LookupEmployeeSalaryResponseDTO> findSalariesByCoveringIndex(int pageNo) {
        List<SalaryId> ids = jpaQueryFactory.query()
                .select(salary.salaryId)
                .from(salary)
                .limit(10)
                .offset(pageNo)
                .fetch();

        return jpaQueryFactory.query()
                .select(Projections.constructor(LookupEmployeeSalaryResponseDTO.class,
                        employee.id.as("empNo"),
                        title.titleId.title,
                        salary.amount.as("salary")
                )).from(salary)
                .where(salary.salaryId.in(ids))
                .innerJoin(employee).on(salary.salaryId.empNo.eq(employee.id))
                .innerJoin(title).on(employee.id.eq(title.titleId.empNo))
                .offset(pageNo)
                .limit(10)
                .fetch();
    }

    @Override
    public List<LookUpSalarySumPerEmployeeResponseDTO> calculateSumOfSalaryPerEmployee() {
        return jpaQueryFactory.query()
                .select(Projections.constructor(LookUpSalarySumPerEmployeeResponseDTO.class,
                        employee.lastName,
                        title.titleId.title,
                        salary.amount.sum().as("sumOfSalaries")
                ))
                .from(salary)
                .innerJoin(employee).on(salary.salaryId.empNo.eq(employee.id))
                .innerJoin(title).on(employee.id.eq(title.titleId.empNo))
                .groupBy(employee.id)
                .fetch();
    }
}
