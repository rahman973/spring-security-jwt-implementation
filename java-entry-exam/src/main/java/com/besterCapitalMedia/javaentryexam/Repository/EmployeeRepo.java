package com.besterCapitalMedia.javaentryexam.Repository;

import com.besterCapitalMedia.javaentryexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
