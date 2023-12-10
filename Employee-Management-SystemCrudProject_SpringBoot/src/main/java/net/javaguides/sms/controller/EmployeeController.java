package net.javaguides.sms.controller;

import net.javaguides.sms.entity.Employee;
import net.javaguides.sms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

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
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
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

	/*
	 * @GetMapping("/sort") public String sortEmployees(@RequestParam String
	 * sortCriteria, Model model) { List<Employee> sortedEmployees =
	 * employeeService.getAllEmployeesSortedBy(sortCriteria);
	 * model.addAttribute("listEmployee", sortedEmployees); return "employee-list";
	 * }
	 */
    
    
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
                // Handle default case or provide a default sorting option
                sortedEmployees = employeeService.getAllEmployeesSortedByFirstName();
                break;
        }

        model.addAttribute("listEmployee", sortedEmployees);
        return "employee-list";
    }

}
