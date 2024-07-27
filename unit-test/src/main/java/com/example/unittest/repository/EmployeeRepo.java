package com.example.unittest.repository;

import com.example.unittest.entity.Employee;
import com.example.unittest.entity.EmployeePkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, EmployeePkId> {
}
