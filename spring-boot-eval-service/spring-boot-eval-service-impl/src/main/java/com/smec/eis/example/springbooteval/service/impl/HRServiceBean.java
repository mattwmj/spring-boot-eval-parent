package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.HRService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Stateless
public class HRServiceBean implements HRService {

    @Inject
    private EmployeeRepository empRepository;
    @Inject
    private JobRepository jobRepository;
    @Resource
    private SessionContext sessionContext;

    public HRServiceBean() {
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeToCreate = new Employee();
        employeeToCreate.setEmail(employee.getEmail());
        employeeToCreate.setFirstName(employee.getFirstName());
        employeeToCreate.setLastName(employee.getLastName());
        employeeToCreate.setHireDate(new Date());
        employeeToCreate.setJob(employee.getJob());
        try {
            employeeToCreate = empRepository.save(employeeToCreate);
            empRepository.flush();
            empRepository.refresh(employeeToCreate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return employeeToCreate;
    }

    @Override
    public List<Employee> findEmployeeByJob(String job) {
        Principal caller = sessionContext.getCallerPrincipal();
        System.out.println(caller.getName());
        List<Employee> employees = empRepository.findByJob_id(job);
        return employees;
    }

    @Override
    public List<Job> findJobByMinSalaryGreaterThan(Long minSalary) {
        List<Job> jobs = jobRepository.findByMinSalaryGreaterThan(minSalary);
        return jobs;
    }

}
