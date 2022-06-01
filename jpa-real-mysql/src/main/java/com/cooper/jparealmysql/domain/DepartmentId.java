package com.cooper.jparealmysql.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DepartmentId implements Serializable {

    @Column(name = "dept_no", length = 4)
    private String deptNo;

    @Column(name = "emp_no")
    private long empNo;

}
