package com.dilemmawalker.yash.dao;

import com.dilemmawalker.yash.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll(){

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        List<Employee> list = query.getResultList();

        return list;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id); //we can also write JPQL query as above
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee savedEmployee = entityManager.merge(employee);
        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee deleteEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(deleteEmployee);
    }
}
