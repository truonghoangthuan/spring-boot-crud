package com.example.springbootcrud.controller;

import com.example.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // Display list of employees
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list_employee", employeeService.getAllEmployee());
        return "index";
    }
}
