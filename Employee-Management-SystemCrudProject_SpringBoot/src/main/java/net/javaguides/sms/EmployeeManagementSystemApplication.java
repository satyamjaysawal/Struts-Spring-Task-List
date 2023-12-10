package net.javaguides.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Employee;
import net.javaguides.sms.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

//		Employee emp1 = new Employee("Ramesh", "Fadatare", "ramesh@gmail.com", 2000);
//		employeeRepository.save(emp1);
//		System.out.println("Employee List Local ::"+ emp1);
//		
//		List<Employee> ls = employeeRepository.findAll();
//		System.out.println(ls);
//		for(Employee es : ls) {
//		System.out.println(es);}
//		
		

	}
}
