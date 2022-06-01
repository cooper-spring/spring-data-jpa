package com.cooper.jparealmysql.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salaries")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salary {

    @EmbeddedId
    private SalaryId salaryId;

    @Column
    private long salary;

}
