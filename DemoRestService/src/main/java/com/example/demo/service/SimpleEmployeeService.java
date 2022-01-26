package com.example.demo.service;

import com.example.demo.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SimpleEmployeeService {

    private static Map<Long, Employee> mockDB = new HashMap<>();
    private static Long autoId = 1000L;

    public Employee readEmployeeData(Long id) {
        Employee employee = mockDB.get(id);
        if(employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    public Employee createEmployee(Employee emp) {
        Long id = autoGenerateId();
        emp.setId(id);
        mockDB.put(id, emp);
        return emp;
    }

    @PostConstruct
    public void setMockDB(){
        Long id = autoGenerateId();
        mockDB.put(id, new Employee(id, "Nila", "nila@nila.com", 1000.0d, "eng"));
    }

    private static Long autoGenerateId(){
        return ++autoId;
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee emp = readEmployeeData(id);
        emp.setSalary(employee.getSalary());
        mockDB.put(id, emp);
    }

    public void deleteEmployee(Long id) {
        readEmployeeData(id);
        mockDB.remove(id);
    }

    public List<Employee> allEmployees() {
        return mockDB.values().stream().collect(Collectors.toList());
    }
}
