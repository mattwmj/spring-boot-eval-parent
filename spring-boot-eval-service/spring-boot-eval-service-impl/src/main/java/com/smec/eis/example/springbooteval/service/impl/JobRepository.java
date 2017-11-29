package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Job;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
@EntityManagerConfig(entityManagerResolver = SecondaryEmResolver.class)
public interface JobRepository extends EntityRepository<Job, String> {

    List<Job> findByTitle(String title);

    List<Job> findByMinSalaryGreaterThan(Long minSalary);

}
