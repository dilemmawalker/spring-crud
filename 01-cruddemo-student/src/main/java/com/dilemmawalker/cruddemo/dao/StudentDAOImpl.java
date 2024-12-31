package com.dilemmawalker.cruddemo.dao;

import com.dilemmawalker.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //sub-set of @Component
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

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

    @Override
    public List<Student> findAll() {
        //Imp: Student is name of java class & not DB table here.
        TypedQuery<Student> queryStudent = entityManager.createQuery("SELECT a FROM Student a", Student.class);
        return queryStudent.getResultList();
    }

    @Override
    public List<Student> findAllByLastNameDesc() {
        TypedQuery<Student> queryStudent = entityManager.createQuery("SELECT a FROM Student a order by lastName desc", Student.class);
        return queryStudent.getResultList();
    }

    @Override
    public List<Student> findByLastName(String name) {
        TypedQuery<Student> studentList = entityManager.createQuery("SELECT a FROM Student a where lastName=:nameDb", Student.class);
        studentList.setParameter("nameDb", name);
        return studentList.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}
