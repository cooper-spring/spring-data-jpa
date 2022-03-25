package com.cooper.springdatajpa.infra;

import com.cooper.springdatajpa.domain.Employee;
import com.cooper.springdatajpa.domain.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository("employeeRepository")
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Override
    public Optional<Employee> findById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

}
