package com.thoughtworks.springbootemployee.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String company_name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private List<Employee> employees;

    public Company(Integer id, String company_name, Integer employeesNumber, List<Employee> employees) {
        this.id = id;
        this.company_name = company_name;
        this.employees = employees;
    }


    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
