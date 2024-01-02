package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Employee;
import net.javaguides.sms.repository.EmployeeRepository;
import net.javaguides.sms.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

//	@Override
  //  public Employee getEmployeeById(Long id) {
    //return employeeRepository.findById(id).orElse(null);
     //}

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchEmployees(String searchTerm) {
        return employeeRepository.searchEmployeesByGenericTerm(searchTerm);
    }

	/*
	 * @Override public List<Employee> getAllEmployeesSortedBy(String sortCriteria)
	 * { // Implement the sorting logic based on your requirements // For
	 * simplicity, this example sorts by the specified criteria return
	 * employeeRepository.findAllByOrderByFirstnameAsc(); }
	 */
    
    
    @Override
    public List<Employee> getAllEmployeesSortedByFirstName() {
        return employeeRepository.findAllByOrderByFirstnameAsc();
    }

    @Override
    public List<Employee> getAllEmployeesSortedByLastName() {
        return employeeRepository.findAllByOrderByLastnameAsc();
    }

    @Override
    public List<Employee> getAllEmployeesSortedByEmail() {
        return employeeRepository.findAllByOrderByEmailAsc();
    }

    
    
}
