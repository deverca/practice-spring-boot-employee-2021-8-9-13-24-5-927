package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private List<Employee> employees = new ArrayList<>();

    public EmployeesController() {

        employees.add(new Employee(1, "Carms", 21, "Female", 1000));
        employees.add(new Employee(2, "Jan Edward", 12, "Male", 2000));

    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping(path = "/{employeeId}")
    public Employee findById(@PathVariable Integer employeeId){
        return employees
                .stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .orElse(null);
    }
}
