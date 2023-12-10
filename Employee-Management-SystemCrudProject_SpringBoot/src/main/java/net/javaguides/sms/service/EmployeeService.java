package net.javaguides.sms.service;

import net.javaguides.sms.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> searchEmployees(String searchTerm);

    List<Employee> getAllEmployeesSortedByFirstName();

    List<Employee> getAllEmployeesSortedByLastName();

    List<Employee> getAllEmployeesSortedByEmail();

}
