package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OldCompanyRepository {

    private List<Company> companies = new ArrayList<>();
    private OldEmployeeRepository oldEmployeeRepository = new OldEmployeeRepository();

//    public OldCompanyRepository() {
//        List<Employee> employees = oldEmployeeRepository.getEmployees();
//        List<Employee> abcEmployees = new ArrayList<>();
//        abcEmployees.add(employees.get(0));
//        abcEmployees.add(employees.get(1));
//        abcEmployees.add(employees.get(2));
//        abcEmployees.add(employees.get(3));
//        abcEmployees.add(employees.get(4));
//
//        List<Employee> defEmployees = new ArrayList<>();
//        defEmployees.add(employees.get(5));
//        defEmployees.add(employees.get(6));
//
//        companies.add(new Company(1, "ABC", abcEmployees.size(), abcEmployees));
//        companies.add(new Company(2, "DEF", defEmployees.size(), defEmployees));
//
//    }

    public List<Company> getAllCompanies() {
        return companies;

    }

    public Company getCompanyById(Integer companyId) {
        return companies.stream().filter(company -> company.getCompanyId().equals(companyId)).findFirst().orElse(null);
    }

    public List<Employee> getEmployeesByCompanyId(Integer companyId) {
        Company filteredCompany = getCompanyById(companyId);
        return filteredCompany.getEmployees();

    }

    public List<Company> getCompaniesByPagination(Integer pageIndex, Integer pageSize) {
        return companies
                .stream()
                .skip((long) (pageIndex - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void addCompany(Company company) {
////        Company newCompany = new Company();
//        newCompany.setCompanyId(companies.size() + 1);
//        newCompany.setCompanyName(company.getCompanyName());
//        newCompany.setEmployees(company.getEmployees());
//        newCompany.setEmployeesNumber(company.getEmployeesNumber());
//
//        companies.add(newCompany);
    }

    public Company updateCompany(Integer companyId, Company companyToUpdate) {

        return companies.stream().filter(company -> company.getCompanyId().equals(companyId)).findFirst()
                .map(company -> updateCompanyInformation(company, companyToUpdate)).orElse(null);
    }

    private Company updateCompanyInformation(Company company, Company companyToUpdate) {
        if (companyToUpdate.getCompanyName() != null) {
            company.setCompanyName(companyToUpdate.getCompanyName());
        }
        if (companyToUpdate.getEmployees() != null) {
            company.setEmployees(companyToUpdate.getEmployees());
            company.setEmployeesNumber(companyToUpdate.getEmployees().size());
        }
        return company;
    }


    public List<Company> deleteCompany(Integer companyId) {
        Company companyToDelete = getCompanyById(companyId);
        companies.remove(companyToDelete);

        return companies;

    }
}
