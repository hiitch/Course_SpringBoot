package com.springboot.demo.myapp.service;

import com.springboot.demo.myapp.dao.EmployeeRepository;
import com.springboot.demo.myapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        if (!result.isPresent()) {
            throw new RuntimeException("Did not found employee id - " + id);
        }

        return result.get();
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
