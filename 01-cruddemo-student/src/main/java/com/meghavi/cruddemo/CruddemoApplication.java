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
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple student object
		System.out.println("Creating 3 new student object...");
		Student tempStudent1 = new Student("Harsha", "Jadav", "meghavijadav@gmail.con");
		Student tempStudent2 = new Student("Vedanti", "Jadav", "vedantijadav@gmail.con");
		Student tempStudent3 = new Student("Alex", "Volkov", "alex@gmail.con");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Meghavi", "Jadav", "meghavijadav@gmail.con");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generated Id: " + tempStudent.getId());
	}
}
