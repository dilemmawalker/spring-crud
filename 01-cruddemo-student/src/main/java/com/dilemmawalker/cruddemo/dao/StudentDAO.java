package com.dilemmawalker.cruddemo.dao;

import com.dilemmawalker.cruddemo.entity.Student;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findAllByLastNameDesc();

    public List<Student> findByLastName(String name);

    public void update(Student student);

    public int delete(String name);

    public void remove(int id);

    public int removeAll();
}
