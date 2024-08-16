package com.example.springserver.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {
    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee){
        repository.save(employee);
        return employee;
    }

    public void delete(Employee employee){
        repository.delete(employee);
    }

    public List<Employee>getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(employee -> {
            employees.add(employee);
        });

        return employees;
    }
}
