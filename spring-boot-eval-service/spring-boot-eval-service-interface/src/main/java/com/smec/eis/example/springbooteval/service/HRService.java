package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.model.Job;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
@Remote
public interface HRService {

    Employee createEmployee(Employee employee);

    List<Employee> findEmployeeByJob(String job);

    List<Job> findJobByMinSalaryGreaterThan(Long minSalary);

}
