package net.javaguides.sms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Student student3 = new Student("tony", "stark", "tony@gmail.com");
		 * studentRepository.save(student3);
		 * 
		 * //////////----studentRepository-----/////////////// List<Student> studentsRP
		 * = studentRepository.findAll();
		 * 
		 * System.out.println("Students list ::"); for (Student s : studentsRP) {
		 * System.out.println(s); }
		 * 
		 * 
		 * //////////////////////////////////////////////////
		 * System.out.println("Students list ::" + student1); List<Student> studentsLS =
		 * new ArrayList<>(); studentsLS.add(student1); studentsLS.add(student2);
		 * studentsLS.add(student3); System.out.println("Students list ::"); for
		 * (Student s : studentsLS) { System.out.println(s); // toString Method }
		 */
	}

}
