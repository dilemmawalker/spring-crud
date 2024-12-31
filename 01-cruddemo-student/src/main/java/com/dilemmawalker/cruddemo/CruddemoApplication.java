package com.dilemmawalker.cruddemo;

import com.dilemmawalker.cruddemo.dao.StudentDAOImpl;
import com.dilemmawalker.cruddemo.entity.Student;
import com.dilemmawalker.cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	private StudentService studentService;

	@Autowired
	CruddemoApplication(StudentService studentService){
		this.studentService = studentService;
	}

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
		//command line runner is executed after all beans are created & app is set up.

		return runner -> {
//			studentService.queryForStudentsForLastName(studentDAO);
//			studentService.queryForStudentsForLastName(studentDAO, "gupta");
//			studentService.updateStudent(studentDAO);
//			studentService.deleteStudent(studentDAO);
//			studentService.remove(studentDAO);
			studentService.removeAll(studentDAO);
		};
	}

}
