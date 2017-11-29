package com.smec.eis.example.springbooteval.service;

import com.smec.eis.example.springbooteval.model.Job;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
@Remote
public interface JobService {

    List<Job> findJobByMinSalaryGreaterThan(Long minSalary);

}
