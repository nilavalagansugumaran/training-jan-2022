package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeJdbcService;
import com.example.demo.service.SimpleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleEmployeeController {

   // @Autowired private SimpleEmployeeService simpleEmployeeService;

   @Autowired private EmployeeJdbcService simpleEmployeeService;

    @GetMapping(path="/employee",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    public Employee getEmployee(@RequestParam Long id) {

       return simpleEmployeeService.readEmployeeData(id);
    }

    @PostMapping(path="/employee",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {

        return simpleEmployeeService.createEmployee(employee);
    }

    @PutMapping(path="/employee/{id}",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        simpleEmployeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path="/employee/{id}",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {

        simpleEmployeeService.deleteEmployee(id);
    }

    @GetMapping(path="/employees",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    public List<Employee> getAllEmployees() {

        return simpleEmployeeService.allEmployees();
    }

}
