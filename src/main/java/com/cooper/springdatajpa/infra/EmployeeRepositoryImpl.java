package com.cooper.springdatajpa.infra;

import com.cooper.springdatajpa.domain.Employee;
import com.cooper.springdatajpa.domain.EmployeeRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.cooper.springdatajpa.domain.QEmployee.employee;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Employee> findById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    //exist 메서드: querydsl로 구현하기
    public boolean exists(Long employeeId) {
        return jpaQueryFactory.selectOne()
                .from(employee)
                .where(employee.id.eq(employeeId))
                .fetchFirst() != null;
    }

}
