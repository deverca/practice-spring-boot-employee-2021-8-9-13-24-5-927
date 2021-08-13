package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable Integer companyId) {

            return companyService.getCompanyById(companyId);


    }

    @GetMapping("/{companyId}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable Integer companyId) {

        return companyService.getEmployeesByCompanyId(companyId);
    }

    @GetMapping(params = {"pageIndex", "pageSize"})
    public List<Company> getCompaniesByPagination(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return companyService.getCompaniesByPagination(pageIndex, pageSize);


    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);

    }

    @PutMapping(path = "/{companyId}")
    public Company updateCompany(@PathVariable Integer companyId, @RequestBody Company companyToUpdate) {
        return companyService.updateCompany(companyId, companyToUpdate);

    }

    @DeleteMapping("/{companyId}")
    public List<Company> deleteCompany(@PathVariable Integer companyId) {
        return companyService.deleteCompany(companyId);
    }

}
