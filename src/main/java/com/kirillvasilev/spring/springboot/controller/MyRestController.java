package com.kirillvasilev.spring.springboot.controller;


import com.kirillvasilev.spring.springboot.entity.Employee;
import com.kirillvasilev.spring.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if(employee==null) {
//            throw new NoSuchEmployeeException("There is no employee with id = " + id + "in database");
//        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmloyee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
//        if (employee==null) {
//            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
//        }

        employeeService.deleteEmployee(id);
        return "Employee with id =" + id + " has been deleted";
    }

}
