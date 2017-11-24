package com.smec.eis.example.springbooteval.controller;

import com.smec.eis.example.springbooteval.model.Employee;
import com.smec.eis.example.springbooteval.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee/findByJob", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findByJobParam(@RequestParam(value = "job") String job) {
        List<Employee> resultList = employeeService.findEmployeeByJob(job);
        return resultList;
    }

    @RequestMapping(value = "/employee/{job}", method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> findByJobPath(@PathVariable String job) {
        List<Employee> resultList = employeeService.findEmployeeByJob(job);
        return resultList;
    }

    @RequestMapping(value = "/employee/createEmployee", method = RequestMethod.POST)
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        return created;
    }

}
