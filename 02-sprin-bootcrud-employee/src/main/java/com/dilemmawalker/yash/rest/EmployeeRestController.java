package com.dilemmawalker.yash.rest;

import com.dilemmawalker.yash.dao.EmployeeDAO;
import com.dilemmawalker.yash.entity.Employee;
import com.dilemmawalker.yash.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
