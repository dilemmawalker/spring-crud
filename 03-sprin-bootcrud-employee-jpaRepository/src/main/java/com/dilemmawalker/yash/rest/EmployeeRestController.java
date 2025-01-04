package com.dilemmawalker.yash.rest;

import com.dilemmawalker.yash.entity.Employee;
import com.dilemmawalker.yash.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    //inject employeeService
    private EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    //expose "/employees" for get query
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id does not exist: "+ employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found: "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return employee;
    }
}
