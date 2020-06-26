package com.besterCapitalMedia.javaentryexam.service;

import com.besterCapitalMedia.javaentryexam.Repository.EmployeeRepo;
import com.besterCapitalMedia.javaentryexam.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;
    @Override
    public List<Employee> getall() {
       return empRepo.findAll();
    }

    @Override
    public void create_update(Employee employee) {
        empRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        empRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return empRepo.findById(id);
    }
}
