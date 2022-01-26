package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeJdbcService {

    @Autowired private EmployeeJdbcRepository employeeJdbcRepository;

    public Employee readEmployeeData(Long id) {
        Employee employee = employeeJdbcRepository.getEmployee(id);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    public Employee createEmployee(Employee emp) {
        return employeeJdbcRepository.addEmployee(emp);
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee emp = readEmployeeData(id);
        emp.setSalary(employee.getSalary());
        employeeJdbcRepository.updateEmployee(emp);;
    }

    public void deleteEmployee(Long id) {
        readEmployeeData(id);
        employeeJdbcRepository.deleteEmployee(id);;
    }

    public List<Employee> allEmployees() {
        return  employeeJdbcRepository.getAllEmployees();
    }
}
