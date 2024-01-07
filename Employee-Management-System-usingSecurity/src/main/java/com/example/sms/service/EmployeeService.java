package com.example.sms.service;



import java.util.List;
import java.util.Optional;

import com.example.sms.entity.Employee;
import com.example.sms.entity.User;
import com.example.sms.entity.UserDto;

public interface EmployeeService {
	
	////////////////////////////////
	
	void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
    
    
    ///////////////////////////////

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> searchEmployees(String searchTerm);

    List<Employee> getAllEmployeesSortedByFirstName();

    List<Employee> getAllEmployeesSortedByLastName();

    List<Employee> getAllEmployeesSortedByEmail();

}
