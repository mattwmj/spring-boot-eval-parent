package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.Employee;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
@Remote
public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> findEmployeeByJob(String job);
}
