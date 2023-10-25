package com.welltech.employee_rest_api.service;

import com.welltech.employee_rest_api.entity.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EmpServiceLocal implements EmployeeService{

    private static List<Employee> employees = new ArrayList<>();

    private static int empCount = 0;

    static {
        employees.add(new Employee(++empCount, "Clifford Agyei","Accra,Ghana",
                LocalDate.now().minusYears(25), "a.agyeiclifford@gmail.com" ));

        employees.add(new Employee(++empCount, "Max Brown","Volta, Ghana",
                LocalDate.now().minusYears(20), "maxb@gmail.com" ));

        employees.add(new Employee(++empCount, "Precious Wills","Central, Ghana",
                LocalDate.now().minusYears(15), "precious.wills@gmail.com" ));
    }

    public List<Employee> findAllEmployees(){
        return employees.stream().toList();
    }

    public Employee findById(int id){
        Predicate<?super Employee> condition = employee -> employee.getId() == id;
        return employees.stream().filter(condition).findFirst().get();
    }

    public void deleteById(int id){
        Predicate<?super Employee> condition = employee -> employee.getId() == id;
        employees.removeIf(condition);
    }
}
