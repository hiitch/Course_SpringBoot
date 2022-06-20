package com.springboot.demo.myapp.service;

import com.springboot.demo.myapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee e);

    void deleteById(int id);
}
