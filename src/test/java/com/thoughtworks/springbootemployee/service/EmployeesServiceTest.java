//package com.thoughtworks.springbootemployee.service;
//
//import com.thoughtworks.springbootemployee.model.Employee;
//import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeesServiceTest {
//
//    @InjectMocks
//    private EmployeeService employeeService;
//
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @Test
//    public void should_return_all_employees_when_getAllEmployees_given_none() {
//
//        //given
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, "Ian", 44, "Female", 20000));
//        employees.add(new Employee(2, "Adomar", 50, "Male", 1000));
//        given(employeeRepository.findAll())
//                .willReturn(employees);
//
//        //when
//        List<Employee> actualEmployees = employeeService.getAllEmployees();
//
//        //then
//
//        assertEquals(employees.size(), actualEmployees.size());
//        assertIterableEquals(employees, actualEmployees);
//
//    }
//
////    @Test
////    public void should_return_employee_with_id_1_when_findEmployeeById_given_employeeId_1() {
////
////        //given
////        List<Employee> employees = new ArrayList<>();
////        employees.add(new Employee(1, "Ian", 44, "Female", 20000));
////        employees.add(new Employee(2, "Adomar", 50, "Male", 1000));
////        given(employeeRepository.findEmployeeById(1))
////                .willReturn(employees.get(0));
////
////        //when
////        Employee actualEmployee = employeeService.findEmployeeById(1);
////        //then
////
////        assertEquals(employees.get(0), actualEmployee);
////
////    }
////
////    @Test
////    public void should_return_employee_with_id_1_when_findEmployeeByPagination_given_pageIndex_1_and_pageSize_1() {
////
////        //given
////        List<Employee> employees = new ArrayList<>();
////        employees.add(new Employee(1, "Ian", 44, "Female", 20000));
////        employees.add(new Employee(2, "Adomar", 50, "Male", 1000));
////        given(employeeRepository.findEmployeesByPagination(1, 1))
////                .willReturn(Collections.singletonList(employees.get(0)));
////
////        //when
////        List<Employee> actualEmployees = employeeService.findEmployeesByPagination(1, 1);
////        //then
////
////        assertEquals(Collections.singletonList(employees.get(0)), actualEmployees);
////
////    }
////
////    @Test
////    public void should_return_male_employees_when_findEmployeesByGender_given_gender_male() {
////        //given
////        List<Employee> employees = new ArrayList<>();
////        employees.add(new Employee(1, "Adomar", 50, "Male", 1000));
////        given(employeeRepository.findEmployeesByGender("male")).willReturn(employees);
////
////        //when
////        List<Employee> actualEmployees = employeeService.findEmployeesByGender("male");
////        //then
////        assertEquals(employees, actualEmployees);
////
////    }
////
////    @Test
////    public void should_add_new_employee_when_addEmployee_given_employee_details() {
////        //given
////        Employee employeeToBeAdded = new Employee(2, "Carms", 21, "Female", 1000000);
////        //when
////        employeeService.addEmployee(employeeToBeAdded);
////        //then
////        verify(employeeRepository, times(1)).addEmployee(employeeToBeAdded);
////
////
////    }
////
////    @Test
////    public void should_update_new_employee_when_updateEmployee_given_updated_employee_details() {
////        //given
////        Employee updatedEmployee = new Employee(1, "Cillian", 47, "Male", 20000);
////        given(employeeRepository.updateEmployee(1, updatedEmployee)).willReturn(updatedEmployee);
////        //when
////        Employee actualEmployee = employeeService.updateEmployee(1, updatedEmployee);
////
////        //then
////
////        assertEquals(updatedEmployee, actualEmployee);
////    }
////
////    @Test
////    public void should_delete_employee_when_deleteEmployee_given_employeeId_1() {
////        //given
////        Integer employeeIdToDelete = 1;
////        //when
////        employeeService.deleteEmployee(employeeIdToDelete);
////        //then
////        verify(employeeRepository, times(1)).deleteEmployee(employeeIdToDelete);
////
////    }
//
//}
