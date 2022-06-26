package com.springboot.demo.myapp.dao;

import com.springboot.demo.myapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
