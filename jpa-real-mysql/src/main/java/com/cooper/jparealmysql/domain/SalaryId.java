package com.cooper.jparealmysql.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class SalaryId implements Serializable {

    @Column(name = "emp_no")
    private Long empNo;

    @Column(name = "from_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

}
