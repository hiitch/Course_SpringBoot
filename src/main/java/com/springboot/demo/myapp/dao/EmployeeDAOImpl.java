package com.springboot.demo.myapp.dao;

import com.springboot.demo.myapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> q = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = q.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee e = currentSession.get(Employee.class, id);
        return e;
    }

    @Override
    public void save(Employee e) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(e);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query q = currentSession.createQuery("delete from Employee where id=:employeeId");
        q.setParameter("employeeId", id);
        q.executeUpdate();
    }
}
