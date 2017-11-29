package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
@EntityManagerConfig(entityManagerResolver = PrimaryEmResolver.class)
public interface EmployeeRepository extends EntityRepository<Employee, Long> {

    List<Employee> findByJob(String job);

}
