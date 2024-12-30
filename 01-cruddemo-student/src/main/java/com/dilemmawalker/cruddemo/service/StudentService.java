package com.dilemmawalker.cruddemo.service;

import com.dilemmawalker.cruddemo.dao.StudentDAOImpl;
import com.dilemmawalker.cruddemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    public void saveStudent(StudentDAOImpl studentDAO){
        System.out.println("construct student with info");
        Student demoStudent = new Student("yash", "handa", "apoorvagupta010801@gmail.com");
        System.out.println("print student: "+ demoStudent);

        //CREATE
        System.out.println("Save student");
        studentDAO.save(demoStudent);
        System.out.println("Student saved successfully");

        System.out.println("Display id of saved student");
        int studentId = demoStudent.getId();
        System.out.println("id of student is: "+ studentId);

        //READ
        System.out.println("find the id in DB");
        Student tempStudent = studentDAO.findById(studentId);
        System.out.println("Student found is: "+ tempStudent);
    }
}
