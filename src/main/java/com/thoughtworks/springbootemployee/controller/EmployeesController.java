package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.model.EmployeeRequest;
import com.thoughtworks.springbootemployee.model.EmployeeResponse;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;


    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        List<EmployeeResponse> allEmployeesResponse = new ArrayList<>();
        allEmployees.forEach(employee -> allEmployeesResponse.add(employeeMapper.toResponse(employee)));

        return allEmployeesResponse;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeResponse findById(@PathVariable Integer employeeId) {
        return employeeMapper.toResponse(employeeService.findEmployeeById(employeeId));
    }

    @GetMapping(params = {"pageIndex", "pageSize"})
    public List<EmployeeResponse> findEmployeesByPagination(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        List<Employee> employees = employeeService.findEmployeesByPagination(pageIndex, pageSize);
        List<EmployeeResponse> employeesResponse = new ArrayList<>();
        employees.forEach(employee -> employeesResponse.add(employeeMapper.toResponse(employee)));

        return employeesResponse;
    }

    @GetMapping(params = "gender")
    public List<Employee> findEmployeesByGender(@RequestParam(required = true) String gender) {
        return employeeService.findEmployeesByGender(gender);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeMapper.toResponse(employeeService.addEmployee(employeeMapper.toEntity(employeeRequest)));
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeResponse updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeRequest employeeRequest) {
        return employeeMapper.toResponse(employeeService.updateEmployee(employeeId, employeeMapper.toEntity(employeeRequest)));
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
    }


}

