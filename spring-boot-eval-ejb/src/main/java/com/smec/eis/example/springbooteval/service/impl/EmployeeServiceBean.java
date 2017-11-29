package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.EmployeeService;
import com.smec.eis.example.springbooteval.service.JobService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class EmployeeServiceBean implements EmployeeService {

    @Inject
    @PrimaryEM
    private EmployeeRepository repository;

    @EJB
    private JobService jobService;

    public EmployeeServiceBean() {
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeToCreate = new Employee();
        employeeToCreate.setEmail(employee.getEmail());
        employeeToCreate.setFirstName(employee.getFirstName());
        employeeToCreate.setLastName(employee.getLastName());
        employeeToCreate.setHireDate(new Date());

        //test jta transaction
//        List<Job> jobs = jobService.findJobByMinSalaryGreaterThan(2000L);
//        for (Job job : jobs) {
//            System.out.println(job.getTitle());
//        }

        employeeToCreate.setJob(employee.getJob());
        try {
            employeeToCreate = repository.save(employeeToCreate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return employeeToCreate;
    }

    @Override
    public List<Employee> findEmployeeByJob(String job) {
        List<Employee> employees = repository.findByJob(job);
        return employees;
    }
}
