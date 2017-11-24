package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
        System.out.println("EmployeeService repository constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("EmployeeService init method called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("EmployeeService destroy method called");
    }

    public Employee createEmployee(Employee employee) {
        Employee employeeToCreate = new Employee();
        employeeToCreate.setEmail(employee.getEmail());
        employeeToCreate.setFirstName(employee.getFirstName());
        employeeToCreate.setLastName(employee.getLastName());
        employeeToCreate.setHireDate(new Date());
        employeeToCreate.setJob(employee.getJob());
        employeeToCreate = repository.save(employeeToCreate);
        return employeeToCreate;
    }

    public List<Employee> findEmployeeByJob(String job) {
        List<Employee> employees = repository.findByJob(job);
        return employees;
    }
}
