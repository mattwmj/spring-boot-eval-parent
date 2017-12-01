package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Employee;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
@EntityManagerConfig(entityManagerResolver = SecondaryEmResolver.class)
public interface EmployeeRepository extends FullEntityRepository<Employee, Long> {

    List<Employee> findByJob_id(String job);

}
