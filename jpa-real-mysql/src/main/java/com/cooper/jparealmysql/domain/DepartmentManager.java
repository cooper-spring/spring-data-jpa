package com.cooper.jparealmysql.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dept_manager")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepartmentManager {

    @EmbeddedId
    private DepartmentId departmentId;

}
