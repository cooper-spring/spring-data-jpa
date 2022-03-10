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
@Table(name = "titles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title {

    @EmbeddedId
    private TitleId titleId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_date")
    private LocalDate toDate;

}
