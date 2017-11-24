package com.smec.eis.example.springbooteval.repository;

import com.smec.eis.example.springbooteval.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByJob(String job);

}
