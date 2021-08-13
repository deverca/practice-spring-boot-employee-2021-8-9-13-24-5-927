package com.thoughtworks.springbootemployee.integration;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void should_return_all_employees_when_call_get_all_employees_api() throws Exception {
        //given
        final Employee employee = new Employee();
        employee.setName("Ian");
        employee.setAge(12);
        employee.setGender("female");
        employee.setSalary(2000);
        employeeRepository.save(employee);
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].name").value("Ian"))
                .andExpect(jsonPath("$[0].age").value(12))
                .andExpect(jsonPath("$[0].gender").value("female"))
                .andExpect(jsonPath("$[0].salary").value(2000));
    }

    @Test
    void should_add_employee_when_call_addEmployee_api() throws Exception {
        //given
        String employee = "{\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"carmela\",\n" +
                "        \"age\": 21,\n" +
                "        \"gender\": \"female\",\n" +
                "        \"salary\": 212121\n" +
                "   \n" +
                "    }";
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON).content(employee))
                .andExpect(status().isCreated());


    }

    @Test
    void should_update_employee_when_call_update_employee_api() throws Exception {
        //given
        final Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Ian");
        employee.setAge(12);
        employee.setGender("female");
        employee.setSalary(2000);
        employeeRepository.save(employee);
        final Employee savedEmployee = employeeRepository.save(employee);
        String employeeWithNewInfo = " {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Ian\",\n" +
                "        \"age\": 21,\n" +
                "        \"gender\": \"female\",\n" +
                "        \"salary\": 2000\n" +
                "   \n" +
                "    }";
        //when
        //then
        int id = savedEmployee.getId();
        mockMvc.perform(MockMvcRequestBuilders.put("/employees/{id}", id)
                .contentType(MediaType.APPLICATION_JSON).
                        content(employeeWithNewInfo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ian"))
                .andExpect(jsonPath("$.age").value("21"))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(jsonPath("$.salary").value(2000));

    }

    @Test
    void should_return_all_employees_By_Gender_when_call_get_All_Employees_By_Gender_employees_api() throws Exception {
        //given
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Cillian");
        employee1.setGender("male");
        employee1.setAge(50);
        employee1.setSalary(2000);
        Employee savedEmployee = employeeRepository.save(employee1);


        Employee employee2 = new Employee();
        employee1.setId(2);
        employee1.setName("Beth");
        employee1.setGender("female");
        employee1.setAge(20);
        employee1.setSalary(2000);
        employeeRepository.save(employee2);
        //when
        //then
        String gender = savedEmployee.getGender();
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/?gender={gender}", gender))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Cillian"))
                .andExpect(jsonPath("$[0].age").value(50))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(2000))
                .andExpect(jsonPath("$[0].id").isNumber());

    }

}
