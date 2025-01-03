package com.dilemmawalker.demo.rest;

import com.dilemmawalker.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student("yash", "handa"));
        students.add(new Student("Apoorva", "gupta"));
        students.add(new Student("Iam", "existing"));

        return students;
    }
}
