package com.cooper.springdatajpa.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@EqualsAndHashCode(of = {"empNo", "title", "fromDate"})
public class TitleId implements Serializable {

    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Column(nullable = false)
    private String title;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

}
