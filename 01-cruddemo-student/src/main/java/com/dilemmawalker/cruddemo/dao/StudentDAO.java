package com.dilemmawalker.cruddemo.dao;

import com.dilemmawalker.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findAllByLastNameDesc();

    public List<Student> findByLastName(String name);
}
