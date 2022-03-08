package com.cooper.springdatajpa.domain;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Long id);

}
