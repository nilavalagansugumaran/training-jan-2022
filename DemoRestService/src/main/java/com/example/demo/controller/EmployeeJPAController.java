package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeJPA;
import com.example.demo.service.EmployeeJPAService;
import com.example.demo.service.EmployeeJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeJPAController {

   @Autowired private EmployeeJPAService simpleEmployeeService;

    @GetMapping(path="/employeeJpa",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    public EmployeeJPA getEmployee(@RequestParam Long id) {

       return simpleEmployeeService.readEmployeeData(id);
    }

    @PostMapping(path="/employeeJpa",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeJPA addEmployee(@RequestBody EmployeeJPA employee) {

        return simpleEmployeeService.createEmployee(employee);
    }

    @PutMapping(path="/employeeJpa/{id}",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeJPA employee) {

        simpleEmployeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path="/employeeJpa/{id}",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {

        simpleEmployeeService.deleteEmployee(id);
    }

    @GetMapping(path="/employeesJpa",headers = {"Content-Type=application/json,application/xml",
            "Accept=application/json,application/xml"})
    public List<EmployeeJPA> getAllEmployees() {

        return simpleEmployeeService.allEmployees();
    }

}
