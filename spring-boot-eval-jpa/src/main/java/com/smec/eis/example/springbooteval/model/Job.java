package com.smec.eis.example.springbooteval.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "JOBS")
public class Job implements Serializable {

    @Id
    @Column(name = "JOB_ID")
    private String id;
    @Column(name = "JOB_TITLE")
    private String title;
    @Column(name = "MIN_SALARY")
    private Long minSalary;
    @Column(name = "MAX_SALARY")
    private Long maxSalary;

}
