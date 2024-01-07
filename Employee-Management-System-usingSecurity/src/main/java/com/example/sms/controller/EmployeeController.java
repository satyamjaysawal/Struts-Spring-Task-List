package com.example.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sms.entity.Employee;
import com.example.sms.entity.User;
import com.example.sms.entity.UserDto;
import com.example.sms.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;



	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	// handler method to handle user registration request
	@GetMapping("register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	// handler method to handle register user form submit request
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
		User existing = employeeService.findByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		employeeService.saveUser(user);
		return "redirect:/register?success";
	}

	@GetMapping("/users")
	public String listRegisteredUsers(Model model) {
		List<UserDto> users = employeeService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	//////////////////////////////////////////////////////////////

	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("listEmployee", employees);
		return "employee-list";
	}

	@GetMapping("/details/{id}")
	public String viewEmployeeDetails(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee.orElse(null));
		return "employee-details";
	}

	@GetMapping("/new")
	public String showAddEmployeeForm() {
		return "employee-form";
	}

	@PostMapping("/insert")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/list";
	}

	@GetMapping("/edit/{id}")
	public String showEditEmployeeForm(@PathVariable Long id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee.orElse(null));
		return "employee-form";
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/list";
	}

	@PostMapping("/search")
	public String searchEmployees(@RequestParam String searchTerm, Model model) {
		List<Employee> searchResults = employeeService.searchEmployees(searchTerm);
		model.addAttribute("listEmployee", searchResults);
		return "employee-list";
	}

	

	@GetMapping("/sort")
	public String sortEmployees(@RequestParam String sortCriteria, Model model) {
		List<Employee> sortedEmployees;

		switch (sortCriteria) {
		case "firstname":
			sortedEmployees = employeeService.getAllEmployeesSortedByFirstName();
			break;
		case "lastname":
			sortedEmployees = employeeService.getAllEmployeesSortedByLastName();
			break;
		case "email":
			sortedEmployees = employeeService.getAllEmployeesSortedByEmail();
			break;
		default:

			sortedEmployees = employeeService.getAllEmployeesSortedByFirstName();
			break;
		}

		model.addAttribute("listEmployee", sortedEmployees);
		return "employee-list";
	}

}
