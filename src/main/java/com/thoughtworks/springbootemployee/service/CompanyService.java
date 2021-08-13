package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Integer companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company does not exist."));
    }

    public List<Employee> getEmployeesByCompanyId(Integer companyId) {
        Company company = companyRepository.findById(companyId).
                orElseThrow(() -> new CompanyNotFoundException("Company does not exist."));
        return company.getEmployees();

    }

    public List<Company> getCompaniesByPagination(Integer pageIndex, Integer pageSize) {
        return companyRepository.findAll(PageRequest.of(pageIndex - 1, pageSize)).getContent();
    }

    public void addCompany(Company company) {
        companyRepository.save(company);

    }


    public Company updateCompany(Integer companyId, Company companyToUpdate) {

        Company company = companyRepository.findById(companyId).orElse(null);
        return companyRepository.save(Objects.requireNonNull(updateCompanyInformation(company, companyToUpdate)));
    }

    private Company updateCompanyInformation(Company company, Company companyToUpdate) {
        if (companyToUpdate.getCompany_name() != null) {
            company.setCompany_name(companyToUpdate.getCompany_name());
        }
        if (companyToUpdate.getEmployees() != null) {
            company.setEmployees(companyToUpdate.getEmployees());
            // company.setEmployeesNumber(companyToUpdate.getEmployees().size());
        }
        return company;
    }

    public void deleteCompany(Integer companyId) {
        companyRepository.deleteById(companyId);
    }
}
