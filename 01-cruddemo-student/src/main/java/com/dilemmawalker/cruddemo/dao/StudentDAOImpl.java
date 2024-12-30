package com.dilemmawalker.cruddemo.dao;

import com.dilemmawalker.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository //sub-set of @Component
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //handles transaction management, necessary for any update DB operation.
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }
}
