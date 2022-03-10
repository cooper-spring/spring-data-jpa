package com.cooper.springdatajpa.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "salaries")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salary {

    @EmbeddedId
    private SalaryId salaryId;

    @Column(name = "salary", nullable = false)
    private Long amount;

    @Column(name = "to_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

}
