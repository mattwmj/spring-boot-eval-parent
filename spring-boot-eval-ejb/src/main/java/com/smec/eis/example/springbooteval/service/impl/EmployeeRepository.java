package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Eager
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByJob(String job);

}
