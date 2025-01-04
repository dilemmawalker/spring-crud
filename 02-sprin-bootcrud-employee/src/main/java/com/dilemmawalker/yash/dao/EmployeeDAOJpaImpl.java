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
}
