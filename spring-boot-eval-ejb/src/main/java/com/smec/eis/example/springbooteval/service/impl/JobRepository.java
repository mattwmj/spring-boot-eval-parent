package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Eager
@SecondaryEM
public interface JobRepository extends PagingAndSortingRepository<Job, String> {

    List<Job> findByTitle(String title);

    List<Job> findByMinSalaryGreaterThan(Long minSalary);

}
