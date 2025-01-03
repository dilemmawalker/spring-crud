package com.dilemmawalker.demo.rest;

import com.dilemmawalker.demo.entity.Student;
import com.dilemmawalker.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("yash", "handa"));
        students.add(new Student("Apoorva", "gupta"));
        students.add(new Student("Iam", "existing"));
    }


    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId < 0) || (studentId >= students.size())){
            //exception
            throw new StudentNotFoundException("errorrrrr");
        }

        return students.get(studentId);
    }
}
