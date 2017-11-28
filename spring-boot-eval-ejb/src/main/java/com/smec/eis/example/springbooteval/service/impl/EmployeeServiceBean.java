package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.service.EmployeeService;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class EmployeeServiceBean implements EmployeeService {

    @Inject
    private EmployeeRepository repository;

    public EmployeeServiceBean() {
    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeToCreate = new Employee();
        employeeToCreate.setEmail(employee.getEmail());
        employeeToCreate.setFirstName(employee.getFirstName());
        employeeToCreate.setLastName(employee.getLastName());
        employeeToCreate.setHireDate(new Date());
        employeeToCreate.setJob(employee.getJob());
        employeeToCreate = getRepository().save(employeeToCreate);
        return employeeToCreate;
    }

    @Override
    public List<Employee> findEmployeeByJob(String job) {
        List<Employee> employees = getRepository().findByJob(job);
        return employees;
    }

    public EmployeeRepository getRepository() {
        return repository;
    }
}
