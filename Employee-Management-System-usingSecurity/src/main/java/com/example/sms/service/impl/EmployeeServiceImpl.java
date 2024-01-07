package com.example.sms.service.impl;





import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Employee;
import com.example.sms.entity.Role;
import com.example.sms.entity.User;
import com.example.sms.entity.UserDto;
import com.example.sms.repository.EmployeeRepository;
import com.example.sms.repository.RoleRepository;
import com.example.sms.repository.UserRepository;
import com.example.sms.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

 
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository,
//			RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//		super();
//		this.employeeRepository = employeeRepository;
//		this.userRepository = userRepository;
//		this.roleRepository = roleRepository;
//		this.passwordEncoder = passwordEncoder;
//	}

	@Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    
    
    
    
    /////////////////////////////////////////////////
    
    
    
    
    
    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

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
