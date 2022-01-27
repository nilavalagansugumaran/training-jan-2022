package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeJPA;
import com.example.demo.repository.EmployeeJPARepository;
import com.example.demo.repository.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeJPAService {

    @Autowired private EmployeeJPARepository employeeJPARepository;

    public EmployeeJPA readEmployeeData(Long id) {
        EmployeeJPA employee = employeeJPARepository.findById(id).orElse(null);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    public EmployeeJPA createEmployee(EmployeeJPA emp) {
        return employeeJPARepository.save(emp);
    }

    public void updateEmployee(Long id, EmployeeJPA employee) {
        EmployeeJPA emp = readEmployeeData(id);
        emp.setSalary(employee.getSalary());
        employeeJPARepository.save(emp);;
    }

    public void deleteEmployee(Long id) {
        readEmployeeData(id);
        employeeJPARepository.deleteById(id);;
    }

    public List<EmployeeJPA> allEmployees() {
        List<EmployeeJPA> employeeJPAList = new ArrayList<>();
        employeeJPARepository.findAll().forEach(e -> employeeJPAList.add(e));
        return employeeJPAList;
    }
}
