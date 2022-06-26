package com.springboot.demo.myapp.dao;

import com.springboot.demo.myapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query q = entityManager.createQuery("from Employee");
        return q.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee e) {
        Employee dbEmployee = entityManager.merge(e);
        e.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query q = entityManager.createQuery("delete from Employee where id=:employeeId");
        q.setParameter("employeeId", id);
        q.executeUpdate();
    }
}
