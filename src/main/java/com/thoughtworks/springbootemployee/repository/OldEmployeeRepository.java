package com.thoughtworks.springbootemployee.repository;


import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OldEmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public OldEmployeeRepository() {
//        employees.add(new Employee(1, "Carms", 21, "Female", 1000, 1));
//        employees.add(new Employee(2, "Jan", 12, "Male", 2000, 1));
//        employees.add(new Employee(3, "Ian", 12, "Female", 2000, 1));
//        employees.add(new Employee(4, "Red", 12, "Male", 20300, 1));
//        employees.add(new Employee(5, "Adomar", 12, "Male", 23000, 1));
//        employees.add(new Employee(6, "DM", 12, "Male", 25000, 1));
//        employees.add(new Employee(7, "Rhea", 12, "Female", 10000, 1));
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public Employee findEmployeeById(Integer employeeId) {
        return employees
                .stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .orElse(null);

    }

    public List<Employee> findEmployeesByPagination(Integer pageIndex, Integer pageSize) {
        return employees
                .stream()
                .skip((long) (pageIndex - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

    }

    public List<Employee> findEmployeesByGender(String gender) {
        return employees.stream().filter(employee -> employee.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
    }
//
//    public void addEmployee(Employee employee) {
//        Employee newEmployee = new Employee(employees.size() + 1, employee.getName(), employee.getAge(),
//                employee.getGender(), employee.getSalary());
//        employees.add(newEmployee);
//    }

    public Employee updateEmployee(Integer employeeId, Employee employeeToBeUpdated) {
        return employees
                .stream()
                .filter(employee -> employee.getId().equals(employeeId))
                .findFirst()
                .map(employee -> updateEmployeeInformation(employee, employeeToBeUpdated))
                .orElse(null);

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
        return employee;
    }

    public void deleteEmployee(Integer employeeId) {
        Employee employeeToDelete = findEmployeeById(employeeId);
        employees.remove(employeeToDelete);

    }
}
