package com.cts.eschool;

import com.cts.eschool.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ESchoolApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ss = SpringApplication.run(ESchoolApplication.class, args);
		StudentService s = ss.getBean(StudentService.class);
		s.addNewStudentDetail(101, "Radha", 78);
		s.addNewStudentDetail(201, "Anand", 45);
		s.addNewStudentDetail(301, "Ahalya", 98);

		s.getAllStudentDetails();
		s.getStudentDetailsById(201);
		s.updateStudentScore(201,50.8);
		s.deleteStudentDetails(101);
		s.getAllStudentDetails();
	}

}
