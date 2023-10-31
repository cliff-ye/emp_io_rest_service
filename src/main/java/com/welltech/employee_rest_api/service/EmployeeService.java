package com.welltech.employee_rest_api.service;

import com.welltech.employee_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee emp);
}
