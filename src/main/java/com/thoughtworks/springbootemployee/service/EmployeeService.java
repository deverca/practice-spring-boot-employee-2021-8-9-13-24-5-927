package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found."));

    }

    public List<Employee> findEmployeesByPagination(Integer pageIndex, Integer pageSize) {
        return employeeRepository.findAll(PageRequest.of(pageIndex - 1, pageSize)).getContent();
    }

    public List<Employee> findEmployeesByGender(String gender) {
        return employeeRepository.findByGender(gender);

    }

    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Integer employeeId, Employee employeeToBeUpdated) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee id not found"));
        return employeeRepository.save(Objects.requireNonNull(updateEmployeeInformation(employee,
                employeeToBeUpdated)));

    }

    private Employee updateEmployeeInformation(Employee employee, Employee employeeToBeUpdated) {
        if (employeeToBeUpdated.getName() != null) {
            employee.setName(employeeToBeUpdated.getName());

        }
        if (employeeToBeUpdated.getAge() != null) {
            employee.setAge(employeeToBeUpdated.getAge());
        }
        if (employeeToBeUpdated.getGender() != null) {
            employee.setGender(employeeToBeUpdated.getGender());
        }
        if (employeeToBeUpdated.getSalary() != null) {
            employee.setSalary(employeeToBeUpdated.getSalary());
        }
        //  employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(Integer employeeId) {
        Employee employeeToDelete = findEmployeeById(employeeId);
        employeeRepository.delete(employeeToDelete);
    }
}
