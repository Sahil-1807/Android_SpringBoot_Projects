package com.example.springserver.controller;

import com.example.springserver.model.employee.Employee;
import com.example.springserver.model.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

    @PostMapping("/employee/save")
    public Employee save(@RequestBody Employee employee){
        return employeeDao.save(employee);
    }
}
