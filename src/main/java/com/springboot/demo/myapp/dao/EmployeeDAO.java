package com.springboot.demo.myapp.dao;

import com.springboot.demo.myapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee e);

    void deleteById(int id);

}
