package com.thoughtworks.springbootemployee.model;

public class EmployeeResponse {
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;

    public EmployeeResponse(String name, Integer age, String gender, Integer salary) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;

    }

    public EmployeeResponse() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender.toLowerCase();
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
