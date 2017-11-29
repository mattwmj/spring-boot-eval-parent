package com.smec.eis.example.springbooteval.service.impl;

import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.JobService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class JobServiceBean implements JobService {

    @Inject
    @SecondaryEM
    JobRepository jobRepository;

    @Override
    public List<Job> findJobByMinSalaryGreaterThan(Long minSalary) {
        List<Job> jobs = jobRepository.findByMinSalaryGreaterThan(minSalary);
        return jobs;
    }
}
