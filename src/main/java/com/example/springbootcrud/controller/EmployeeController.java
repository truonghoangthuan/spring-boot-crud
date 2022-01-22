package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Employee;
import com.example.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // Display list of employees
    @GetMapping("/")
    public String index(Model model) {
//        List<Employee> listEmployee = employeeService.getAllEmployee();
//        model.addAttribute("list_employee", listEmployee);
//        return "index";
        return findPaginated(1, model);
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployee = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItem", page.getTotalElements());
        model.addAttribute("listEmployee", listEmployee);
        return "index";
    }
}
