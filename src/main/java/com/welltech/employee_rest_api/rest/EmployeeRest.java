package com.welltech.employee_rest_api.rest;

import com.welltech.employee_rest_api.entity.Employee;
import com.welltech.employee_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRest {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/auth")
    public String basicAuthCheck(){
        return "success";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmp(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable int id){
        Employee emp = employeeService.findById(id);

        if(emp == null){
            throw new RuntimeException("Employee not found");
        }
        employeeService.deleteById(emp.getId());
        return "deleted";
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        return employeeService.save(emp);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeService.save(emp);
    }
}
