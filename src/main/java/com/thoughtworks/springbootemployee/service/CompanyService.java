package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.repository.OldCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    OldCompanyRepository oldCompanyRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Company> getAllCompanies() {
        return oldCompanyRepository.getAllCompanies();
    }

    public Company getCompanyById(Integer companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    public List<Employee> getEmployeesByCompanyId(Integer companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company != null) {
            return company.getEmployees();
        }
        return null;
    }

    public List<Company> getCompaniesByPagination(Integer pageIndex, Integer pageSize) {
        return oldCompanyRepository.getCompaniesByPagination(pageIndex, pageSize);
    }

    public void addCompany(Company company) {
        oldCompanyRepository.addCompany(company);

    }


    public Company updateCompany(Integer companyId, Company companyToUpdate) {

        return oldCompanyRepository.updateCompany(companyId, companyToUpdate);
    }

    public List<Company> deleteCompany(Integer companyId) {
        return oldCompanyRepository.deleteCompany(companyId);
    }
}
