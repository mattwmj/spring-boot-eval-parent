package com.smec.eis.example.springbooteval.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @SequenceGenerator(name = "employeeIdGenerator", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "employeeIdGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hireDate;
    @Column(name = "JOB_ID")
    private String job;
    private String email;
}
