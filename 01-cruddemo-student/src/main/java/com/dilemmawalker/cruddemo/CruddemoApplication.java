package com.dilemmawalker.cruddemo;

import com.dilemmawalker.cruddemo.dao.StudentDAOImpl;
import com.dilemmawalker.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

//	private StudentDAOImpl studentDAO;
//
//	@Autowired
//	CruddemoApplication(StudentDAOImpl studentDAO){
//		this.studentDAO = studentDAO;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAO){
		//command line runner is executed after all beans are created & app is setup.

		return runner -> {
			saveStudent(studentDAO);
		};
	}

	public void saveStudent(StudentDAOImpl studentDAO){
		System.out.println("construct student with info");
		Student demoStudent = new Student("apoorva", "gupta", "apoorvagupta010801@gmail.com");
		System.out.println("print student: "+ demoStudent);

		System.out.println("Save student");
		studentDAO.save(demoStudent);
		System.out.println("Student saved successfully");

		System.out.println("Display id of saved student");
		int studentId = demoStudent.getId();
		System.out.println("id of student is: "+ studentId);
	}

}
