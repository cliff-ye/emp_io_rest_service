package com.welltech.employee_rest_api.rest;

import com.welltech.employee_rest_api.entity.Employee;
import com.welltech.employee_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRest {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmp(){
        return employeeService.findAllEmployees();
    }

}
