package com.meghavi.cruddemo;

import com.meghavi.cruddemo.dao.StudentDAO;
import com.meghavi.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		//lambda expression
		return runner -> {
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated ID: " + theId);

		//retrieve student based of id: primary key
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);
	}
}

