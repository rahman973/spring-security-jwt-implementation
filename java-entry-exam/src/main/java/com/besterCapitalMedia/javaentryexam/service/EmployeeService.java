package com.besterCapitalMedia.javaentryexam.service;

import com.besterCapitalMedia.javaentryexam.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService{
    public List<Employee> getall();
    public void create_update(Employee employee);
    public void deleteEmployee(int id);
    public Optional<Employee> findById(int id);
}