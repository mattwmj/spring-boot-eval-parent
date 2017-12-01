package com.smec.eis.example.springbootevalweb;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.model.Job;
import com.smec.eis.example.springbooteval.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
public class HRController {

    @Autowired
    private EJBLocator ejbLocator;
    private HRService employeeService = null;

    private synchronized HRService getHRService() {
        if (employeeService == null) {
            try {
                employeeService = ejbLocator.getEJB(HRService.class);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return employeeService;
    }

    @RequestMapping(value = "/employee/findByJob", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findByJobParam(@RequestParam(value = "job") String job) {
        try {
            List<Employee> resultList = getHRService().findEmployeeByJob(job);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/employee/{job}", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findByJobPath(@PathVariable String job) {
        List<Employee> resultList = getHRService().findEmployeeByJob(job);
        return resultList;
    }

    @RequestMapping(value = "/employee/createEmployee", method = RequestMethod.POST)
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        Employee created = getHRService().createEmployee(employee);
        return created;
    }

    @RequestMapping(value = "/job/findJobByMinSalaryGreaterThan", method = RequestMethod.GET)
    public @ResponseBody
    List<Job> findJobByMinSalaryGreaterThan(@RequestParam(value = "minSalary") Long minSalary) {
        try {
            List<Job> resultList = getHRService().findJobByMinSalaryGreaterThan(minSalary);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
