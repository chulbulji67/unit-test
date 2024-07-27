package com.example.unittest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmployeePkId.class)
public class Employee {
    @Id
    private int employeeId;
    @Id
    private int deptId;
    private String name;
    private String email;
    private String phone;
}
