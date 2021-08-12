//package com.thoughtworks.springbootemployee.service;
//
//import com.thoughtworks.springbootemployee.model.Company;
//import com.thoughtworks.springbootemployee.model.Employee;
//import com.thoughtworks.springbootemployee.repository.OldCompanyRepository;
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
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class CompaniesServiceTest {
//    @InjectMocks
//    CompanyService companyService;
//    @Mock
//    OldCompanyRepository oldCompanyRepository;
//
//
//    @Test
//    public void should_return_all_companies_when_getAllCompanies_given_none() {
//        //given
//        Employee employee1 = new Employee(1, "Ian", 44, "Male", 20000,1);
//        Employee employee2 = new Employee(2, "Rhea", 44, "Female", 30000,1);
//        List<Company> companies = new ArrayList<>();
//
//        companies.add(new Company(1, "ABC", 1, Collections.singletonList(employee1)));
//        companies.add(new Company(2, "DEF", 1, Collections.singletonList(employee2)));
//        given(oldCompanyRepository.getAllCompanies()).willReturn(companies);
//        //when
//        List<Company> actualCompanies = companyService.getAllCompanies();
//
//        //then
//        assertIterableEquals(companies, actualCompanies);
//
//
//    }
//
//
//    @Test
//    public void should_return_company_with_id_1_when_findCompanyById_given_id_1() {
//
//        //given
//        Employee employee = new Employee(2, "Rhea", 44, "Female", 30000);
//        Company company = new Company(1, "ABC", 1, Collections.singletonList(employee));
//        given(oldCompanyRepository.getCompanyById(1)).willReturn(company);
//        //when
//        Company actualCompany = companyService.getCompanyById(1);
//
//        //then
//        assertEquals(company, actualCompany);
//
//    }
//
//
//    @Test
//    public void should_return_employees_with_companyId_1_when_getEmployeesByCompanyId_given_companyId_1() {
//
//        //given
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, "Rhea", 44, "Female", 30000));
//        employees.add(new Employee(2, "John", 44, "Male", 30000));
//        given(oldCompanyRepository.getEmployeesByCompanyId(1)).willReturn(employees);
//        //when
//        List<Employee> actualEmployees = companyService.getEmployeesByCompanyId(1);
//
//        //then
//        assertEquals(employees, actualEmployees);
//
//
//    }
//
//    @Test
//    public void should_return_employees_with_companyId_1_when_getEmployeesByPagination_given_pageIndex_1_and_pageSize_1() {
//
//        //given
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, "Rhea", 44, "Female", 30000));
//        employees.add(new Employee(2, "John", 44, "Male", 30000));
//        Company company = new Company(1, "ABC", 2, employees);
//        given(oldCompanyRepository.getCompaniesByPagination(1, 1)).willReturn(Collections.singletonList(company));
//        //when
//        List<Company> actualCompanies = companyService.getCompaniesByPagination(1, 1);
//
//        //then
//        assertEquals(Collections.singletonList(company), actualCompanies);
//
//
//    }
//
//    @Test
//    public void should_add_new_company_when_addCompany_given_new_company_details() {
//        //given
//        Company companyToBeAdded = new Company(1, "ABC", 1,
//                Collections.singletonList(new Employee(1, "CL", 21, "Female", 200000)));
//
//        //when
//        companyService.addCompany(companyToBeAdded);
//
//        //then
//        verify(oldCompanyRepository, times(1)).addCompany(companyToBeAdded);
//
//    }
//
//    @Test
//    public void should_update_company_with_companyId_1_when_updateCompany_given_new_company_details() {
//        //given
//        Company companyToUpdate = new Company(1, "AHAHHA", 1,
//                Collections.singletonList(new Employee(1, "Cillian", 45, "Male", 222222)));
//
//        given(oldCompanyRepository.updateCompany(1, companyToUpdate)).willReturn(companyToUpdate);
//        //when
//        Company actualCompany = companyService.updateCompany(1, companyToUpdate);
//        //then
//
//        assertEquals(companyToUpdate, actualCompany);
//
//    }
//
//    @Test
//    public void should_return_all_employees_when_deleteCompany_given_companyId_to_delete_1() {
//        //given
//
//        List<Company> companies = new ArrayList<>();
//        companies.add(new Company(1, "ABC", 1, Collections.singletonList(new Employee(1, "CL", 21, "Female", 12222))));
//        companies.add(new Company(2, "ABCsas", 1, Collections.singletonList(new Employee(1, "Carms", 21, "Female", 12222))));
//        given(oldCompanyRepository.deleteCompany(1)).willReturn(companies);
//        //when
//
//        List<Company> actualCompanies = companyService.deleteCompany(1);
//
//        //then
//
//        assertEquals(companies, actualCompanies);
//    }
//}
