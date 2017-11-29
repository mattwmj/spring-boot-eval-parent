package com.smec.eis.example.springbootevalweb;


import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private EJBLocator ejbLocator;
    private JobService jobService = null;

    private synchronized JobService getJobService() {
        if (jobService == null) {
            try {
                jobService = ejbLocator.getEJB(JobService.class);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return jobService;
    }

    @RequestMapping(value = "/job/findJobByMinSalaryGreaterThan", method = RequestMethod.GET)
    public @ResponseBody
    List<Job> findJobByMinSalaryGreaterThan(@RequestParam(value = "minSalary") Long minSalary) {
        try {
            List<Job> resultList = getJobService().findJobByMinSalaryGreaterThan(minSalary);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
