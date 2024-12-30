package com.dilemmawalker.cruddemo.dao;

import com.dilemmawalker.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(Integer id);
}
