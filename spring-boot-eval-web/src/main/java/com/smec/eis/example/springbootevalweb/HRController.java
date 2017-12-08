package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.HRService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.security.auth.Subject;
import java.security.AccessController;
import java.util.List;

@RestController
@Lazy
public class HRController {

    @EJBClient
    private HRService hrService;

    @PreAuthorize("#job == 'IT_PROG' or hasRole('AppTester')")
    @RequestMapping(value = "/employee/findByJob", method = RequestMethod.GET)
    public @ResponseBody
    List findByJobParam(@RequestParam String job) {
        try {
            List<Employee> resultList = hrService.findEmployeeByJob(job);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @RolesAllowed("AppTester")
    @RequestMapping(value = "/employee/{job}", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findByJobPath(@PathVariable String job) {
        List<Employee> resultList = hrService.findEmployeeByJob(job);
        return resultList;
    }

    @PreAuthorize("#employee.job.maxSalary <= 10000 or hasRole('AppTester')")
    @RequestMapping(value = "/api/employee/createEmployee", method = RequestMethod.POST)
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        Employee created = hrService.createEmployee(employee);
        return created;
    }

    @RequestMapping(value = "/job/findJobByMinSalaryGreaterThan", method = RequestMethod.GET)
    public @ResponseBody
    List<Job> findJobByMinSalaryGreaterThan(@RequestParam(value = "minSalary") Long minSalary) {
        try {
            List<Job> resultList = hrService.findJobByMinSalaryGreaterThan(minSalary);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
