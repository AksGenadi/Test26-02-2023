package com.company.controllers;

import com.company.beans.Employee;
import com.company.repo.EmployeeRepository;
import com.company.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;

    @Autowired
    public CompanyController(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping("/employees")
    public long addEmployee(@RequestBody Employee employee){
        Employee saved = employeeRepository.save(employee);
        return saved.getId();
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable long id){
        return employeeRepository.findById(id).get();
    }

    @GetMapping("/employees/byname/{name}")
    public List<Employee> getEmployees(@PathVariable String name){
        return employeeRepository.findEmployeeByName(name);
    }
}