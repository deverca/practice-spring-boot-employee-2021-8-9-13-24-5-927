package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.model.EmployeeRequest;
import com.thoughtworks.springbootemployee.model.EmployeeResponse;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;



    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeResponse findById(@PathVariable Integer employeeId) {
        // return employeeService.findEmployeeById(employeeId);
        return employeeMapper.toResponse(employeeService.findEmployeeById(employeeId));
    }

    @GetMapping(params = {"pageIndex", "pageSize"})
    public List<Employee> findEmployeesByPagination(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {

        return employeeService.findEmployeesByPagination(pageIndex, pageSize);
    }

    @GetMapping(params = "gender")
    public List<Employee> findEmployeesByGender(@RequestParam(required = true) String gender) {

        return employeeService.findEmployeesByGender(gender);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeMapper.toResponse(employeeService.addEmployee(employeeMapper.toEntity(employeeRequest)));
        //return employeeService.addEmployee(employeeMapper.toEntity(employeeRequest));

    }

    @PutMapping(path = "/{employeeId}")
    public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeRequest employeeRequest) {

        return employeeService.updateEmployee(employeeId, employeeMapper.toEntity(employeeRequest));
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);

    }


}

